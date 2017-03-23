package action;


import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginOauthDAO;
import dto.UsersDTO;
import util.FacebookOauth;

/**
 * FACEBOOKでログインする為のクラス
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class LoginFacebookAction extends ActionSupport implements SessionAware,ServletResponseAware, ServletRequestAware{

	public static final int NETWORK_NAME_FACEBOOK = 2;

	/**
	 * シリアルバージョンUID
	 */
	private static final long serialVersionUID = 6842090219984600595L;


	/**
	 * ユーザーID
	 */
	private int userId;

	/**
	 * ログインフラグ
	 */
	private boolean loginFlg;

	/**
	 * OAuthID
	 */
	private String oauthId;

	/**
	 * OAuthAccount
	 */
	private String oauthAccount;

	/**
	 * レスポンス
	 */
	private HttpServletRequest request;

	/**
	 * リクエスト
	 */
	private HttpServletResponse response;

	/**
	 * セッション
	 */
	private Map<String,Object> session;

	/**
	 * FACEBOOK 認証の実行メソッド ユーザー認証をセッションする
	 * @return rtn
	 * @throws SQLException
	 */
	public String execute()throws SQLException{
		String rtn = ERROR;
		FacebookOauth oauth = new FacebookOauth();
		Map<String,String> userMap = null;

		//ERROR発生解除
		System.out.println(oauth.getAccessToken(request,response));
		userMap = oauth.getAccessToken(request,response);

		if(userMap == null){
			return rtn;
		}

		String oauthId = userMap.get("id");
		System.out.println("ouathId: " + oauthId);
		String oauthAccount = userMap.get("name");
		System.out.println("ouathAccount: " + oauthAccount);

		LoginOauthDAO dao = new LoginOauthDAO();
		UsersDTO dto = new UsersDTO();
		//足したよ
		dto = dao.select(oauthId,oauthAccount);

		System.out.println("めっちゃ変えたよ");

		//dao.select(oauthId,oauthAccount)
		if(dto.isAlredyUser()){
			loginFlg = dto.isLoginFlg();
			userId = dto.getUserId();
			oauthAccount = dto.getOauthAccount();

			int count = 0;
			count = dao.update(userId, 1);
			if(count > 0){
				session.clear();
				session.put("oauthAccount",oauthAccount);
				session.put("userId",userId);
				session.put("loginFlg",true);
				rtn = SUCCESS;
			}
			return rtn;
		}
		boolean result = dao.insert(oauthId,oauthAccount,NETWORK_NAME_FACEBOOK);

		System.out.println("LoginFacebookAction100");
		if(!result){
			return rtn;
		}

		dao.select(oauthId,oauthAccount);
		loginFlg = dto.isLoginFlg();
		userId = dto.getUserId();

		if(!loginFlg){
			if(dao.update(userId,1) > 0){
				session.clear();
				session.put("oauthAccount",dto.getOauthAccount());
				session.put("loginFlg",loginFlg);
				session.put("userId",userId);
				rtn = SUCCESS;
			}
		}
		return rtn;
	}

	/**
	 * リクエスト格納メソッド
	 * @param request リクエスト
	 */
	public void setServletRequest(HttpServletRequest request){
		this.request = request;
	}

	/**
	 * レスポンス格納メソッド
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response){
		this.response = response;
	}

	/**
	 * ログインフラグ取得メソッド
	 * @param loginFlg ログインフラグ
	 */
	public boolean isLoginFlg(){
		return loginFlg;
	}

	/**
	 * ログインフラグ格納メソッド
	 * @return loginFlg ログインフラグ
	 */
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg = loginFlg;
	}

	/**
	 * ユーザID取得メソッド
	 * @param userId ユーザーID
	 */
	public int getUserId(){
		return userId;
	}

	/**
	 * ユーザーID格納メソッド
	 * @return userId ユーザーID
	 */
	public void setUserId(int userId){
		this.userId = userId;
	}

	/**
	 * OAuthID取得メソッド
	 * @param oauthId
	 */
	public String getOauthId(){
		return oauthId;
	}

	/**
	 * OAuthIDの格納メソッド
	 * @return oauthId
	 */
	public void setOauthId(String oauthId){
		this.oauthId = oauthId;
	}

	/**
	 * OAuthAccountメソッド
	 * @param oauthAccount
	 */
	public String getOauthAccount(){
		return oauthAccount;
	}

	/**
	 * OAuthAccount格納メソッド
	 * @return oauthAccount
	 */
    public void setOauthAccount(String oauthAccount){
    	this.oauthAccount = oauthAccount;
    }

	/**
	 * セッション取得メソッド
	 * @return session セッション
	 */
	public Map<String,Object> getSession(){
		return session;
	}

	/**
	 * セッション格納メソッド
	 * @param session セッション
	 */
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
