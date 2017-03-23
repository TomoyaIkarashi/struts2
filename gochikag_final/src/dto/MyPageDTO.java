package dto;

/** MyPageDTO
 * アイテムの値を格納するクラス
 * @author Tomoya Ikarashi
 * @since  3/10
 * @version 1.1
 */

public class MyPageDTO {



	private String date;
	private String itemName;
	private int amount;
	/**
	 * dateを取得します。
	 * @return date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * dateを設定します。
	 * @param date date
	 */
	public void setDate(String date) {
		this.date = date;
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
	 * amountを取得します。
	 * @return amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * amountを設定します。
	 * @param amount amount
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}