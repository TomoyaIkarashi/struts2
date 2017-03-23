package dto;

/**
 * UsersDTO
 * ユーザー情報の値を格納するクラス
 * @author Kazune Miyagi
 * @since 3/9
 * @version 1.1
 */

public class UsersDTO {



	private int userId;// ユーザーID
	private String password;
	private String familyName;
	private String givenName;
	private String familyNameKanji;
	private String familyNameKana;
	private String givenNameKanji;
	private String givenNameKana;
	private String postal;
	private String address;
	private String phoneNumber;
	private String phoneEmail;
	private String mobileNumber;
	private String mobileEmail;
	private String sex;
	private String birthday;
	private boolean userdelFlg;
	private boolean loginFlg;
	private int userFlg;
	private String year;
	private String month;
	private String oauthId;
	private int oauthName;
	private String oauthAccount;
	private String registerDay;
	private String updateDay;

	//ちょっと足すよ
	private boolean isAlredyUser;

	/**
	 * @return userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId セットする userId
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password セットする password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return familyName
	 */
	public String getFamilyName() {
		return familyName;
	}
	/**
	 * @param familyName セットする familyName
	 */
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	/**
	 * @return givenName
	 */
	public String getGivenName() {
		return givenName;
	}
	/**
	 * @param givenName セットする givenName
	 */
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	/**
	 * @return familyNameKanji
	 */
	public String getFamilyNameKanji() {
		return familyNameKanji;
	}
	/**
	 * @param familyNameKanji セットする familyNameKanji
	 */
	public void setFamilyNameKanji(String familyNameKanji) {
		this.familyNameKanji = familyNameKanji;
	}
	/**
	 * @return familyNameKana
	 */
	public String getFamilyNameKana() {
		return familyNameKana;
	}
	/**
	 * @param familyNameKana セットする familyNameKana
	 */
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	/**
	 * @return givenNameKanji
	 */
	public String getGivenNameKanji() {
		return givenNameKanji;
	}
	/**
	 * @param givenNameKanji セットする givenNameKanji
	 */
	public void setGivenNameKanji(String givenNameKanji) {
		this.givenNameKanji = givenNameKanji;
	}
	/**
	 * @return givenNameKana
	 */
	public String getGivenNameKana() {
		return givenNameKana;
	}
	/**
	 * @param givenNameKana セットする givenNameKana
	 */
	public void setGivenNameKana(String givenNameKana) {
		this.givenNameKana = givenNameKana;
	}
	/**
	 * @return postal
	 */
	public String getPostal() {
		return postal;
	}
	/**
	 * @param postal セットする postal
	 */
	public void setPostal(String postal) {
		this.postal = postal;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber セットする phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return phoneEmail
	 */
	public String getPhoneEmail() {
		return phoneEmail;
	}

	/**
	 * @param phoneEmail セットする phoneEmail
	 */
	public void setPhoneEmail(String phoneEmail) {
		this.phoneEmail = phoneEmail;
	}
	/**
	 * @return mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}
	/**
	 * @param mobileNumber セットする mobileNumber
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	/**
	 * @return mobileEmail
	 */
	public String getMobileEmail() {
		return mobileEmail;
	}
	/**
	 * @param mobileEmail セットする mobileEmail
	 */
	public void setMobileEmail(String mobileEmail) {
		this.mobileEmail = mobileEmail;
	}
	/**
	 * @return sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex セットする sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday セットする birthday
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return userdelFlg
	 */
	public boolean isUserdelFlg() {
		return userdelFlg;
	}
	/**
	 * @param userdelFlg セットする userdelFlg
	 */
	public void setUserdelFlg(boolean userdelFlg) {
		this.userdelFlg = userdelFlg;
	}
	/**
	 * @return loginFlg
	 */
	public boolean isLoginFlg() {
		return loginFlg;
	}
	/**
	 * @param loginFlg セットする loginFlg
	 */
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	/**
	 * @return userFlg
	 */
	public int getUserFlg() {
		return userFlg;
	}
	/**
	 * @param userFlg セットする userFlg
	 */
	public void setUserFlg(int userFlg) {
		this.userFlg = userFlg;
	}
	/**
	 * @return year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year セットする year
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month セットする month
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return oauthId
	 */
	public String getOauthId() {
		return oauthId;
	}
	/**
	 * @param oauthId セットする oauthId
	 */
	public void setOauthId(String oauthId) {
		this.oauthId = oauthId;
	}
	/**
	 * @return oauthName
	 */
	public int getOauthName() {
		return oauthName;
	}
	/**
	 * @param oauthName セットする oauthName
	 */
	public void setOauthName(int oauthName) {
		this.oauthName = oauthName;
	}
	/**
	 * @return oauthAccount
	 */
	public String getOauthAccount() {
		return oauthAccount;
	}
	/**
	 * @param oauthAccount セットする oauthAccount
	 */
	public void setOauthAccount(String oauthAccount) {
		this.oauthAccount = oauthAccount;
	}
	/**
	 * @return registerDay
	 */
	public String getRegisterDay() {
		return registerDay;
	}
	/**
	 * @param registerDay セットする registerDay
	 */
	public void setRegisterDay(String registerDay) {
		this.registerDay = registerDay;
	}
	/**
	 * @return updateDay
	 */
	public String getUpdateDay() {
		return updateDay;
	}
	/**
	 * @param updateDay セットする updateDay
	 */
	public void setUpdateDay(String updateDay) {
		this.updateDay = updateDay;
	}
	public boolean isAlredyUser() {
		return isAlredyUser;
	}
	public void setAlredyUser(boolean isAlredyUser) {
		this.isAlredyUser = isAlredyUser;
	}

}
