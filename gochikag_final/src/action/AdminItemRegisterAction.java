package action;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.opensymphony.xwork2.ActionSupport;

import dao.AdminItemRegisterDAO;

/**
 * 新しい商品を追加するアクション
 * @author Tomohiro Konasaka
 * @since 2017/03/21
 * @version 1.1
 */

public class AdminItemRegisterAction extends ActionSupport {
	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * 商品名
	 */
	private String itemName;
	/**
	 * 商品価格
	 */
	private float price;
	/**
	 * 在庫数
	 */
	private int stockNumber;
	/**
	 * 商品画像
	 */
	private String mainPicture;
	/**
	 * 分類
	 */
	private String category;
	/**
	 * 商品詳細画像1
	 */
	private String subPicture1;
	/**
	 * 商品詳細画像2
	 */
	private String subPicture2;
	/**
	 * 商品詳細画像3
	 */
	private String subPicture3;
	/**
	 * 日本語の商品詳細説明
	 */
	private String detailJa;
	/**
	 * 英語の商品詳細説明
	 */
    private String detailEn;

	/**
	 * 実行メソッド
	 * 新しい商品を追加する
	 * @author Tomohiro Konasaka
	 * @return result
	 * @throws SQLException
	 */
	public String execute() {
		AdminItemRegisterDAO dao = new AdminItemRegisterDAO();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String now = sdf.format(cal.getTime());

		if(dao.insertIntoItem(itemName, price, stockNumber, mainPicture, now, category) == 1){
			int itemId = dao.select();
			if(dao.insertIntoPictures(itemId, subPicture1, subPicture2, subPicture3) == 1){
				if(dao.insertIntoDetail(itemId, detailJa, detailEn) == 1){
					System.out.println("追加しました");
					return SUCCESS;
				} else{
					return ERROR;
				}
			}else{
				return ERROR;
			}
		}else{
			return ERROR;
		}
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
	 * @param itemId 商品ID
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	/**
	 * 商品名を取得します。
	 *
	 * @return 商品名
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 商品名を設定します。
	 *
	 * @param itemName 商品名
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 商品価格を取得します。
	 *
	 * @return 商品価格
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * 商品価格を設定します。
	 *
	 * @param price 商品価格
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * 在庫数を取得します。
	 *
	 * @return 在庫数
	 */
	public int getStockNumber() {
		return stockNumber;
	}
	/**
	 * 在庫数を設定します。
	 *
	 * @param stockNumber 在庫数
	 */
	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}
	/**
	 * 商品画像を取得します。
	 *
	 * @return 商品画像
	 */
	public String getMainPicture() {
		return mainPicture;
	}
	/**
	 * 商品画像を設定します。
	 *
	 * @param mainPicture 商品画像
	 */
	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}
	/**
	 * 商品詳細画像1を取得します。
	 *
	 * @return 商品詳細画像1
	 */
	public String getSubPicture1() {
		return subPicture1;
	}
	/**
	 * 商品詳細画像1を設定します。
	 *
	 * @param subPicture1 商品詳細画像1
	 */
	public void setSubPicture1(String subPicture1) {
		this.subPicture1 = subPicture1;
	}
	/**
	 * 商品詳細画像2を取得します。
	 *
	 * @return 商品詳細画像2
	 */
	public String getSubPicture2() {
		return subPicture2;
	}
	/**
	 * 商品詳細画像2を設定します。
	 *
	 * @return subPicture2 商品詳細画像2
	 */
	public void setSubPicture2(String subPicture2) {
		this.subPicture2 = subPicture2;
	}
	/**
	 * 商品詳細画像3を取得します。
	 *
	 * @return 商品詳細画像3
	 */
	public String getSubPicture3() {
		return subPicture3;
	}
	/**
	 * 商品詳細画像3を設定します。
	 *
	 * @return subPicture3 商品詳細画像3
	 */
	public void setSubPicture3(String subPicture3) {
		this.subPicture3 = subPicture3;
	}
	/**
	 * 商品の日本語詳細を取得します。
	 *
	 * @return 商品の日本語詳細
	 */
	public String getDetailJa() {
		return detailJa;
	}
	/**
	 * 商品の日本語詳細を設定します。
	 *
	 * @return detailJa 商品の日本語詳細
	 */
	public void setDetailJa(String detailJa) {
		this.detailJa = detailJa;
	}
	/**
	 * 商品の英語詳細を取得します。
	 *
	 * @return 商品の英語詳細
	 */
	public String getDetailEn() {
		return detailEn;
	}
	/**
	 * 商品の英語詳細を設定します。
	 *
	 * @param detailEn 商品の英語詳細
	 */
	public void setDetailEn(String detailEn) {
		this.detailEn = detailEn;
	}
	/**
	 * 分類を取得します。
	 *
	 * @return 分類
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * 分類を設定します。
	 *
	 * @param category 分類
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}