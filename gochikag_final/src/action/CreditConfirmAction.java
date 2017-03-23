package action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.CreditConfirmDAO;
import dto.CreditConfirmDTO;



/**
 *クレジット情報を認証するアクション
 * @author MIYAGI KAZUNE
 * @since 2017/03/19
 * @version 1.1
 *
 */
public class CreditConfirmAction extends ActionSupport implements SessionAware{

/* userIdを取得するためにsessionから値を受け取る準備 */
	private Map<String, Object>session;

/* pay.jspから受け取る値一覧 */
	private String lastName;
	private String firstName;
	private String cardBrand;
	private String creditNumber1;
	private String creditNumber2;
	private String creditNumber3;
	private String creditNumber4;
	private int securityCode;
	private String expirationYear;
	private String expirationMonth;

/* クレジットの認証のために必要な変数を用意 */
	private int totalPrice;
	private int userId;
	private String loginId;
	private String nameE;
	private String expirationDay;
	private String firstSixDigits;
	private String lastFourDigits;

/* execute method*/
	/**
	 *クレジット情報を認証するアクション
	 *@author MIYAGI KAZUNE
	 *@return result
	 *@throws SQLException
	 */
	public String execute() throws SQLException{

	/* クレジット認証に必要な変数群 */
		boolean checkedNumberFlag = false;
		boolean checkedCreditInfoFlag = false;
		CreditConfirmDAO dao = new CreditConfirmDAO();
		String stringCardBrand = convert(cardBrand);
		String creditNumber = creditNumber1 + creditNumber2 + creditNumber3 + creditNumber4;
		firstSixDigits = creditNumber.substring(0,6);
		lastFourDigits = creditNumber.substring(creditNumber.length()-4);
		System.out.println(firstSixDigits);
		System.out.println(lastFourDigits);
		nameE = lastName + " " +firstName;
		expirationDay = expirationYear + "-" + expirationMonth;

	/* Phase1: ユーザーがログインできていなかったらエラー */
		if(session.containsKey("userId")){
			userId= Integer.parseInt((String) session.get("userId"));
		}else {
			/*　ログインしてないからエラー */
			return ERROR;
		}

	/* Phase2: クレジットの上６桁の番号がvisa, master, amexのクレジット会社と照合するか確認。できなかったら上６桁のエラー */
		if(dao.select1(stringCardBrand, firstSixDigits)){
			System.out.println(firstSixDigits);
			checkedNumberFlag = true;
		}else{
			/* 上６桁が違うからエラー */
			return ERROR;
		}

	/* Phase3: 選択されたクレジットカード会社専用のDBを呼び出して、クレジット情報を照合する */
		CreditConfirmDTO dto = dao.select2(cardBrand, creditNumber);
		if(dto.getNameE().equals(nameE)){
			if(dto.getSecurityCode() == securityCode){
				if(dto.getExpirationDay().equals(expirationDay)){
					loginId = dto.getLoginId();
					checkedCreditInfoFlag = true;
				}else{
					/* 期限が違うからエラー */
					return ERROR;
				}
			}else{
				/* セキュリティ番号が違うからエラー */
				return ERROR;
			}
		}else{
			/* クレジット名義が違うからエラー */
			return ERROR;
		}

	/* Phase4: ユーザーがログイン状態であるかつ、クレジットカード上６桁の認証を通過しているかつ、クレジット情報の認証を通過しているかもう一度確認 */
		if(userId != 0 && checkedNumberFlag && checkedCreditInfoFlag){
			if(dao.update(userId)){
				totalPrice = dao.select3(userId);
				return SUCCESS;
			}
		}
		/* 予期せぬとしてエラー */
		return ERROR;
	}


	/* MySQLで使う検索ワードの生成 */
    private String convert(String cardBrand) {
        String stringCardBrand = null;
        if(cardBrand.equals("visa")) {
            stringCardBrand = "'%VISA%'";
        }else if(cardBrand.equals("master")) {
            stringCardBrand = "'%MasterCard%'";
        }else if(cardBrand== "amex") {
            stringCardBrand = "'%AMERICAN EXPRESS%' or 'アメリカン' or 'AMEX'";
        }
        return stringCardBrand;
    }

	/**
	 * sessionを取得します。
	 * @return session
	 */
	/* pay.jspからconfirm.jspへ値の受け渡しが必要な変数のためgetterおよびsetter両方を用意 */
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
	 * lastNameを取得します。
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * lastNameを設定します。
	 * @param lastName lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * firstNameを取得します。
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}


	/**
	 * firstNameを設定します。
	 * @param firstName firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * cardBrandを取得します。
	 * @return cardBrand
	 */
	public String getCardBrand() {
		return cardBrand;
	}


	/**
	 * cardBrandを設定します。
	 * @param cardBrand cardBrand
	 */
	public void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}


	/**
	 * expirationMonthを設定します。
	 * @param expirationMonth expirationMonth
	 */
	/* pay.jspから値をもらうだけなのでsetterのみ必要な変数 */
	public void setExpirationMonth(String expirationMonth) {
		this.expirationMonth = expirationMonth;
	}


	/**
	 * expirationDayを設定します。
	 * @param expirationDay expirationDay
	 */
	public void setExpirationDay(String expirationDay) {
		this.expirationDay = expirationDay;
	}


	/**
	 * securityCodeを設定します。
	 * @param securityCode securityCode
	 */
	public void setSecurityCode(int securityCode) {
		this.securityCode = securityCode;
	}


	/**
	 * expirationYearを設定します。
	 * @param expirationYear expirationYear
	 */
	public void setExpirationYear(String expirationYear) {
		this.expirationYear = expirationYear;
	}


	/**
	 * creditNumber1を設定します。
	 * @param creditNumber1 creditNumber1
	 */
	public void setCreditNumber1(String creditNumber1) {
		this.creditNumber1 = creditNumber1;
	}


	/**
	 * creditNumber2を設定します。
	 * @param creditNumber2 creditNumber2
	 */
	public void setCreditNumber2(String creditNumber2) {
		this.creditNumber2 = creditNumber2;
	}


	/**
	 * creditNumber3を設定します。
	 * @param creditNumber3 creditNumber3
	 */
	public void setCreditNumber3(String creditNumber3) {
		this.creditNumber3 = creditNumber3;
	}


	/**
	 * creditNumber4を設定します。
	 * @param creditNumber4 creditNumber4
	 */
	public void setCreditNumber4(String creditNumber4) {
		this.creditNumber4 = creditNumber4;
	}


	/**
	 * nameEを取得します。
	 * @return nameE
	 */
	/* confirm.jspに値を渡すだけなのでgetterのみ必要な変数 */
	public String getNameE() {
		return nameE;
	}


	/**
	 * loginIdを取得します。
	 * @return loginId
	 */
	public String getLoginId() {
		return loginId;
	}


	/**
	 * totalPriceを取得します。
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}


	/**
	 * firstSixDigitsを取得します。
	 * @return firstSixDigits
	 */
	public String getFirstSixDigits() {
		return firstSixDigits;
	}


	/**
	 * lastFourDigitsを取得します。
	 * @return lastFourDigits
	 */
	public String getLastFourDigits() {
		return lastFourDigits;
	}
}
