package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginDAO;
import dto.LoginDTO;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * Eメール
	 */
	private String phoneEmail;
	/**
	 * パスワード
	 */
	private String password;
	/**
	 * ユーザーID
	 */
	private String userId;
	/**
	 * ユーザーフラッグ
	 */
	private String userFlg;
	/**
	 * ログインフラッグ
	 */
	private String loginFlg;
	/**
	 * カウント
	 */
	private int count;
	/**
	 * dtoリスト
	 */
	private LoginDTO dto;
	/**
	 * dto2リスト
	 */
	private LoginDTO dto2;
	/**
	 * セッション
	 */
	private Map<String,Object>session;

	/**
	 * 実行メソッド ユーザーIDとパスワードでログインする
	 * @author TOMOYA IKARASHI
	 * @return ret
	 * @throws SQLException
	 */
	public String execute()throws Exception{

		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		dto = dao.select(phoneEmail,password);

		session.put("userId",dto.getUserId());
		System.out.println("LOGIN IDだよ");
		System.out.println(session.get("userId"));

		/*
		 * ログイン時のメールとパスワード認証
		 */
		if(phoneEmail.equals(dto.getPhoneEmail())){
			if(password.equals(dto.getPassword())){
				/*gochikagDBにデータが無ければinsertする
				 *
				 */
				count = dao.count(phoneEmail,password);
				System.out.println("actionCount="+count);
				ret = SUCCESS;

				if(count==0){
					dto2 = dao.insert(dto.getUserId(),dto.getPhoneEmail(),dto.getLoginFlg(),dto.getUserFlg(),dto.getPassword());

					if(dto2==null){
						/*insert出来なければエラーを返す
						 *
						 */
						return ret;
					}
				}
				/*
				 * user_flg = 3 （管理者）
				 */
				String flg = dto.getUserFlg();
				if(flg.equals("3")) {
					ret = "admin";
					System.out.println(ret);

				/*user_flg =1, 2 (一般)
				 *
				 */
				}else if((flg.equals("1"))&&(flg.equals("2"))){
					System.out.println("userFlg="+flg);
				ret = SUCCESS;
				}

				/*ログインフラグをtrueにする
				 *
				 */
				int lFlg = dao.update(phoneEmail, password);
				int lFlg2 = dao.update2(phoneEmail, password);
				System.out.println("update="+lFlg);
				System.out.println("update2="+lFlg2);

				int rs =0;
				if(rs==0){
					/*update出来なければエラーを返す
					 *
					 */
					return ret;
				}

			}
		}
		return ret;
	}

	/**
	 * Eメールを取得します。
	 * @return Eメール
	 */
	public String getPhoneEmail() {
		return phoneEmail;
	}

	/**
	 * Eメールを設定します。
	 * @param phoneEmail Eメール
	 */
	public void setPhoneEmail(String phoneEmail) {
		this.phoneEmail = phoneEmail;
	}

	/**
	 * パスワードを取得します。
	 * @return パスワード
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * パスワードを設定します。
	 * @param password パスワード
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ユーザーIDを取得します。
	 * @return ユーザーID
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * ユーザーIDを設定します。
	 * @param userId ユーザーID
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * ユーザーフラッグを取得します。
	 * @return ユーザーフラッグ
	 */
	public String getUserFlg() {
		return userFlg;
	}

	/**
	 * ユーザーフラッグを設定します。
	 * @param userFlg ユーザーフラッグ
	 */
	public void setUserFlg(String userFlg) {
		this.userFlg = userFlg;
	}

	/**
	 * ログインフラッグを取得します。
	 * @return ログインフラッグ
	 */
	public String getLoginFlg() {
		return loginFlg;
	}

	/**
	 * ログインフラッグを設定します。
	 * @param loginFlg ログインフラッグ
	 */
	public void setLoginFlg(String loginFlg) {
		this.loginFlg = loginFlg;
	}

	/**
	 * カウントを取得します。
	 * @return カウント
	 */
	public int getCount() {
	    return count;
	}

	/**
	 * カウントを設定します。
	 * @param count カウント
	 */
	public void setCount(int count) {
	    this.count = count;
	}

	/**
	 * dtoリストを取得します。
	 * @return dtoリスト
	 */
	public LoginDTO getDto() {
		return dto;
	}

	/**
	 * dtoリストを設定します。
	 * @param dto dtoリスト
	 */
	public void setDto(LoginDTO dto) {
		this.dto = dto;
	}

	/**
	 * セッションを取得します。
	 * @return セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * セッションを設定します。
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>)session;
	}

	/**
	 * dto2リストを取得します。
	 * @return dto2リスト
	 */
	public LoginDTO getDto2() {
		return (LoginDTO) dto2;
	}

	/**
	 * dto2リストを設定します。
	 * @param dto2 dto2リスト
	 */
	public void setDto2(LoginDTO dto2) {
		this.dto2 = (LoginDTO) dto2;
	}
}