package action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoBackCreditConfirmDAO;


/**
 * クレジット認証を解除するアクション
 * @author YONESHIMA AI
 * @since 2017/03/10
 */
public class GoBackCreditConfirmAction extends ActionSupport implements SessionAware{

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 *クレジット認証を解除する実行メソッド
	 *@author YONESHIMA AI
	 *@return result
	 *@throws SQLException
	 */
	public String execute() throws SQLException{
		int userId = 0;
		if(session.containsKey("userId")){
			userId= Integer.parseInt((String) session.get("userId"));
		}
		GoBackCreditConfirmDAO dao = new GoBackCreditConfirmDAO();
		if(dao.update(userId)){
			return SUCCESS;
		}
		return ERROR;
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
		this.session = session;
	}
}
