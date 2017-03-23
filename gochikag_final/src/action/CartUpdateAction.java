package action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CartUpdateDAO;

/**
 * カート情報を取得するアクション
 * @author RIYO TAKAHASHI
 * @since 2017/03/21
 * @version 1.1
 */
public class CartUpdateAction extends ActionSupport implements SessionAware{
	//フィールド
	/**
	 *在庫数
	 */
	private String itemCount;
	/**
	 * 商品ID
	 */
	private String itemId;
	/**
	 * 価格
	 */
	private int price;
	/**
	 * 合計金額
	 */
	private int amount;
	/**
	 * ユーザーID
	 */
	private int userId; //sessionから取得
	/**
	 * セッション
	 */
	private Map<String,Object> session;


	/**
	 * 実行メソッド
	 *カート情報を取得するアクション
	 * @author RIYO TAKAHASHI
	 * @return result
	 * @throws SQLException
	 */
	//executeメソッド
	public String execute() throws SQLException{

		CartUpdateDAO dao=new CartUpdateDAO();
		userId=0;
		if(session.containsKey("userId")){
			userId= Integer.parseInt((String) session.get("userId"));
		}

		int rs = dao.update(Integer.parseInt(itemId),Integer.parseInt(itemCount),price,amount,userId);
		if(rs != 0) return SUCCESS;
		return ERROR;
	}


	/**
	 * 在庫数を取得します。
	 * @return 在庫数
	 */
	public String getItemCount() {
		return itemCount;
	}


	/**
	 * 在庫数を設定します。
	 * @param itemCount 在庫数
	 */
	public void setItemCount(String itemCount) {
		this.itemCount = itemCount;
	}


	/**
	 * ユーザーIDを取得します。
	 * @return ユーザーID
	 */
	public int getUserId() {
		return userId;
	}


	/**
	 * ユーザーIDを設定します。
	 * @param userId ユーザーID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
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


	/**
	 * 商品IDを取得します。
	 * @return 商品ID
	 */
	public String getItemId() {
		return itemId;
	}


	/**
	 * 商品IDを設定します。
	 * @param itemId 商品ID
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


	/**
	 * 価格を取得します。
	 * @return 価格
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * 価格を設定します。
	 * @param price 価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}


	/**
	 * 合計金額を取得します。
	 * @return 合計金額
	 */
	public int getAmount() {
		return amount;
	}


	/**
	 * 合計金額を設定します。
	 * @param amount 合計金額
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
}