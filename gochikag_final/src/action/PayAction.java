package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.PayDAO;

/**
 * カート内商品を支払い画面に反映させる為のアクション
 * @author TAKAHASHI RIYO
 * @since 2017/03/21
 *
 */
public class PayAction extends ActionSupport implements SessionAware{

	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 実行メソッド
	 * カート内商品の支払い方法
	 * @author TAKAHASHI RIYO
	 * @return ret
	 * @throws SQLException
	 *
	 */
	public String execute() throws SQLException{
		int userId = 0;
		String ret = ERROR;
		if(session.containsKey("userId")) {
			userId = Integer.parseInt((String) session.get("userId"));
		}
		PayDAO dao = new PayDAO();
		if(dao.update(userId)){
			ret = SUCCESS;
		}
		return ret;
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
