package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LogoutDAO;

/**
 * ログアウトする為のアクション
 * @author WATANABE JUNA
 * @since 2017/03/21
 * @version 1.1
 *
 */


public class LogoutAction extends ActionSupport implements SessionAware{
	/**
	 * セッション
	 */
	private Map<String, Object> session;
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
	private int userId;
	/**
	 * 商品ID
	 */
	private String itemId;


	/**
	 * ログアウト実行メソッド
	 * @author WATANABE JUNNNA
	 * @return ret
	 * @throws SQLException
	 */
	public String execute()throws SQLException{

		System.out.println("user_id="+session);

		String ret = ERROR;
		LogoutDAO dao = new LogoutDAO();

		//それぞれのDBの更新件数を格納
		int flg = 0;
		int flg2 = 0;
		flg= dao.update(phoneEmail, password);
		flg2 = dao.update2(phoneEmail, password);

		//gochikagDBのcartテーブルのデータを削除
		int rs=dao.delete(userId);

		//sessionを破棄する
		if((flg==0)&&(flg2==0)){
			((SessionMap<String, Object>)session).invalidate();
			ret = SUCCESS;
		}else{
			//update出来なければエラーを返す
			ret = ERROR;
		}
		return ret;
	}


	/**
	 * sessionを取得します。
	 * @return session
	 */
	public Map<String, Object> getSession(){
		return session;
	}


	/**
	 * sessionを設定します。
	 * @param session session
	 */
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>)session;

	}


	/**
	 * phoneEmailを取得します。
	 * @return phoneEmail
	 */
	public String getPhoneEmail() {
	    return phoneEmail;
	}


	/**
	 * phoneEmailを設定します。
	 * @param phoneEmail phoneEmail
	 */
	public void setPhoneEmail(String phoneEmail) {
	    this.phoneEmail = phoneEmail;
	}


	/**
	 * passwordを取得します。
	 * @return password
	 */
	public String getPassword() {
	    return password;
	}


	/**
	 * passwordを設定します。
	 * @param password password
	 */
	public void setPassword(String password) {
	    this.password = password;
	}


	/**
	 * userIdを取得します。
	 * @return userId
	 */
	public int getUserId() {
	    return userId;
	}


	/**
	 * userIdを設定します。
	 * @param userId userId
	 */
	public void setUserId(int userId) {
	    this.userId = userId;
	}


	/**
	 * itemIdを取得します。
	 * @return itemId
	 */
	public String getItemId() {
	    return itemId;
	}


	/**
	 * itemIdを設定します。
	 * @param itemId itemId
	 */
	public void setItemId(String itemId) {
	    this.itemId = itemId;
	}

}
