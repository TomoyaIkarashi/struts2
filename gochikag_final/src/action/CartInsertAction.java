
package action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CartInsertDAO;

/**
 * カートにアイテムを入れるアクション
 * @author UEKI KAYO
 * @since 2017/03/21
 * @version 1.1
 */
public class CartInsertAction extends ActionSupport implements SessionAware {

	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * 在庫数
	 */
	private int itemCount;
	/**
	 * 価格
	 */
	private int price;
	/**
	 * セッション
	 */
	private Map<String, Object> session;

	/**
	 * 実行メソッド
	 * カートにアイテムを入れるアクション
	 * @author UEKI KAYO
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		int userId = 0;
		if (session.containsKey("userId")) {
			userId = Integer.parseInt((String) session.get("userId"));
		}
		if(userId == 0){
			return ERROR;
		}

		int amount = itemCount * price;
		CartInsertDAO dao = new CartInsertDAO();

		List<Integer> itemIdList = dao.select(userId, itemId);
		for (Integer i : itemIdList) {
			// もし同じitemIdの商品をcartに入れようとしている場合はそれを防ぐ
			if (i == itemId)
				return SUCCESS;
		}

		int rs = dao.insert(userId, itemId, itemCount, amount);
		if (rs != 0)
			return SUCCESS;
		return ERROR;
	}

	/**
	 * 商品IDを取得します。
	 *
	 * @return 商品ID
	 */
	public int getItemId() {
		return itemId;
	}


	/**
	 * 商品IDを設定します。
	 *
	 * @param itemId
	 *            商品ID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * セッションを取得します。
	 *
	 * @return セッション
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * 在庫数を取得します。
	 *
	 * @return 在庫数
	 */
	public int getItemCount() {
		return itemCount;
	}

	/**
	 * 在庫数を設定します。
	 *
	 * @param itemCount
	 *            在庫数
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	/**
	 * セッションを設定します。
	 *
	 * @param session
	 *            セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	/**
	 * 価格を取得します。
	 *
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 価格を設定します。
	 *
	 * @param price
	 *            価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
}
