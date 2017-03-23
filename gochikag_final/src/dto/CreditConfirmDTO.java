package dto;

/**
 * CreditConfirmDTO
 * @author Riyo Takahashi
 * @since 3/9
 * @version 1.1
 */

public class CreditConfirmDTO {


	private String loginId;
	private String nameE; //last_name + first_name
	private int securityCode;
	private String expirationDay;

	/**
	 * loginIdを取得します。
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}
	/**
	 * loginIdを設定します。
	 * @param loginId loginId
	 */
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**
	 * nameEを取得します。
	 * @return nameE
	 */
	public String getNameE() {
		return nameE;
	}
	/**
	 * nameEを設定します。
	 * @param nameE nameE
	 */
	public void setNameE(String nameE) {
		this.nameE = nameE;
	}
	/**
	 * securityCodeを取得します。
	 * @return securityCode
	 */
	public int getSecurityCode() {
		return securityCode;
	}
	/**
	 * securityCodeを設定します。
	 * @param securityCode securityCode
	 */
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}
	/**
	 * expirationDayを取得します。
	 * @return expirationDay
	 */
	public String getExpirationDay() {
		return expirationDay;
	}
	/**
	 * expirationDayを設定します。
	 * @param expirationDay expirationDay
	 */
	public void setExpirationDay(String expirationDay) {
		this.expirationDay = expirationDay;
	}


}