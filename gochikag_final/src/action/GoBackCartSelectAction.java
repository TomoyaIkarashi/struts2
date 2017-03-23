package action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.GoBackCartSelectDAO;


/**
 *クレジット認証およびカートフラグを解除するアクション
 * @author SAKAMOTO YOSHIKAZU
 *@since 2017/03/17
 */
public class GoBackCartSelectAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;

	/**
	 * クレジット認証およびカートフラグを解除するアクション
	 * @author SAKAMOTO YOSHIKAZU
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws SQLException{
		int userId = 0;
		if(session.containsKey("userId")){
			userId= Integer.parseInt((String) session.get("userId"));
		}

		GoBackCartSelectDAO dao = new GoBackCartSelectDAO();
		if(dao.update(userId)){
			return SUCCESS;
		}
		return ERROR;
	}

	/**
	 * sessionを取得します。
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * sessionを設定します。
	 * @param session session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
