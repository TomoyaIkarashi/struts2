package action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminItemManageDAO;
import dto.ItemDTO;

/**
 * 管理者画面にて商品検索する為のアクション
 *
 * @author SAKAMOTO YOSHIKAZU
 * @since 2017/03/13
 */
public class AdminItemManageAction extends ActionSupport {

	private int itemId;
	private String itemName;
	private String price;
	private int stockNumber;
	private String category;
	private int phase;

	private ItemDTO dto;
	private List<String> nameList;
	private List<Integer>stockNumberList;
	private List<Integer> newStockNumberList;
	private List<ItemDTO> dtoList;

	/**
	 * 実行メソッド
	 * 管理者画面にて商品の更新、削除を行う
	 * @author MIYAGI KAZUNE
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws SQLException {
		String ret = ERROR;
		newStockNumberList = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++){
			newStockNumberList.add(i);
		}
		AdminItemManageDAO dao = new AdminItemManageDAO();
		//phase4
		if(phase == 4){

		}

		//phase3
		if(phase == 3){
			if(dao.update(itemId, stockNumber) == 0) return ERROR;
		}

		//phase1
		nameList = dao.select1(category);
		if (!nameList.isEmpty()) ret = SUCCESS;

		if(phase == 1) {
			phase = 2;
			return ret;
		}

		//phase2
		dto = dao.select2(itemName);
		if(dto.isItemFlg()) ret = SUCCESS;

		if(phase == 2){
			phase = 3;
			return ret;
		}

		return ret;
	}

	/**
	 * dtoを取得します。
	 * @return dto
	 */
	public ItemDTO getDto() {
		return dto;
	}

	/**
	 * dtoを設定します。
	 * @param dto dto
	 */
	public void setDto(ItemDTO dto) {
		this.dto = dto;
	}

	/**
	 * itemIdを取得します。
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}

	/**
	 * itemIdを設定します。
	 * @param itemId itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	/**
	 * itemNameを取得します。
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}

	/**
	 * itemNameを設定します。
	 * @param itemName itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * priceを取得します。
	 * @return price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * priceを設定します。
	 * @param price price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * categoryを取得します。
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * categoryを設定します。
	 * @param category category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * nameListを取得します。
	 * @return nameList
	 */
	public List<String> getNameList() {
		return nameList;
	}

	/**
	 * nameListを設定します。
	 * @param nameList nameList
	 */
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

	/**
	 * dtoListを取得します。
	 * @return dtoList
	 */
	public List<ItemDTO> getDtoList() {
		return dtoList;
	}

	/**
	 * dtoListを設定します。
	 * @param dtoList dtoList
	 */
	public void setDtoList(List<ItemDTO> dtoList) {
		this.dtoList = dtoList;
	}

	/**
	 * stockNumberを取得します。
	 * @return stockNumber
	 */
	public int getStockNumber() {
		return stockNumber;
	}

	/**
	 * stockNumberを設定します。
	 * @param stockNumber stockNumber
	 */
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	/**
	 * stockNumberListを取得します。
	 * @return stockNumberList
	 */
	public List<Integer> getStockNumberList() {
		return stockNumberList;
	}

	/**
	 * stockNumberListを設定します。
	 * @param stockNumberList stockNumberList
	 */
	public void setStockNumberList(List<Integer> stockNumberList) {
		this.stockNumberList = stockNumberList;
	}

	/**
	 * phaseを取得します。
	 * @return phase
	 */
	public int getPhase() {
		return phase;
	}

	/**
	 * phaseを設定します。
	 * @param phase phase
	 */
	public void setPhase(int phase) {
		this.phase = phase;
	}

	/**
	 * newStockNumberListを取得します。
	 * @return newStockNumberList
	 */
	public List<Integer> getNewStockNumberList() {
		return newStockNumberList;
	}

	/**
	 * newStockNumberListを設定します。
	 * @param newStockNumberList newStockNumberList
	 */
	public void setNewStockNumberList(List<Integer> newStockNumberList) {
		this.newStockNumberList = newStockNumberList;
	}

}