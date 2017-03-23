package dto;

/**
 * PayConfirmDTO
 * アイテムの値を格納するクラス
 * @author Kayoko Ueki
 * @since 3/10
 * @version 1.1
 */

public class PayConfirmDTO {


	private int itemId;
	private int itemCount;
	private int amount;

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
	 * itemCountを取得します。
	 * @return itemCount
	 */
	public int getItemCount() {
		return itemCount;
	}
	/**
	 * itemCountを設定します。
	 * @param itemCount itemCount
	 */
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
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
