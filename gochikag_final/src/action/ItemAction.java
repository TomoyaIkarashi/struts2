package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ItemDAO;
import dto.ItemDTO;

/**
 * 各商品の詳細を表示する為のアクション
 * @author SAKAMOTO YOSHIKAZU
 * @since 2017/03/21
 *
 */
public class ItemAction extends ActionSupport {

	/**
	 * 商品ID
	 */
	private String itemId;
	/**
	 * itemDTO
	 */
	private ItemDTO dto;
	/**
	 * 在庫数
	 */
	private int stockNumber;
	/**
	 * 価格
	 */
	private int price;
	/**
	 * 在庫数をリストに格納
	 */
	private List<Integer> stockNumberList;



	/**
	 * 実行メソッド 商品詳細に遷移
	 * @author SAKAMOTO YOSHIKAZU
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws SQLException{

		ItemDAO dao = new ItemDAO();
		dto = dao.select(Integer.parseInt(itemId));
		stockNumber = dto.getStockNumber();
		price = (int) dto.getPrice();
		stockNumberList = new ArrayList<Integer>();
		for(int i=1; i<=stockNumber; i++){
			stockNumberList.add(i);
		}
		return SUCCESS;
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
	 * itemDTOを取得します。
	 * @return itemDTO
	 */
	public ItemDTO getDto() {
		return dto;
	}

	/**
	 * itemDTOを設定します。
	 * @param dto itemDTO
	 */
	public void setDto(ItemDTO dto) {
		this.dto = dto;
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
	 * 在庫数を取得します。
	 * @return 在庫数
	 */
	public int getStockNumber() {
		return stockNumber;
	}

	/**
	 * 在庫数を設定します。
	 * @param stockNumber 在庫数
	 */
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	/**
	 * 在庫数をリストに格納を取得します。
	 * @return 在庫数をリストに格納
	 */
	public List<Integer> getStockNumberList() {
		return stockNumberList;
	}

	/**
	 * 在庫数をリストに格納を設定します。
	 * @param stockNumberList 在庫数をリストに格納
	 */
	public void setStockNumberList(List<Integer> stockNumberList) {
		this.stockNumberList = stockNumberList;
	}



}