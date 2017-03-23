package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CartSelectDAO;
import dto.CartSelectDTO;


/**
 * カート情報を取得するアクション
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class CartSelectAction extends ActionSupport implements SessionAware{
	//フィールド
	/**
	 * 商品ID
	 */
	private int userId;
	/**
	 * 商品
	 */
	private List<CartSelectDTO> itemList;
	private ArrayList tempStockList;
	private List<ArrayList> itemStockList;
	private Map<String,Object> session;
	private int totalPrice;

	//executeメソッド
	/**
	 *カート情報を取得するアクション
	 *@author MIYAGI KAZUNE
	 *@return result
	 *@throws SQLException
	 */
	public String execute() throws SQLException{
		System.out.println("here");
		userId = 0;
		if(session.containsKey("userId")){
			userId= Integer.parseInt((String) session.get("userId"));
		}
		CartSelectDAO dao=new CartSelectDAO();
		itemList = new ArrayList<CartSelectDTO>();
		itemList = dao.select(userId);
		itemStockList = new ArrayList<ArrayList>();
		totalPrice = 0;

		for(CartSelectDTO item : itemList){
			totalPrice += item.getAmount();
			tempStockList = new ArrayList<Integer>();
			for(int i = 1; i <= item.getStockCount(); i++){
				tempStockList.add(i);
			}
			itemStockList.add(tempStockList);
		}

		if(itemList.isEmpty()) return ERROR;
		return SUCCESS;
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


	/**
	 * itemListを取得します。
	 * @return itemList
	 */
	public List<CartSelectDTO> getItemList() {
		return itemList;
	}


	/**
	 * itemListを設定します。
	 * @param itemList itemList
	 */
	public void setItemList(List<CartSelectDTO> itemList) {
		this.itemList = itemList;
	}


	/**
	 * totalPriceを取得します。
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}


	/**
	 * totalPriceを設定します。
	 * @param totalPrice totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	/**
	 * itemStockListを取得します。
	 * @return itemStockList
	 */
	public List<ArrayList> getItemStockList() {
		return itemStockList;
	}


	/**
	 * itemStockListを設定します。
	 * @param itemStockList itemStockList
	 */
	public void setItemStockList(List<ArrayList> itemStockList) {
		this.itemStockList = itemStockList;
	}
}
