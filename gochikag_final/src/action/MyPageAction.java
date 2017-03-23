package action;

import java.sql.SQLException;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.MyPageDAO;
import dto.MyPageDTO;


/**
 * マイページにてお客様情報の確認する為のアクション
 * @author KONASAKA TOMOHIRO
 * @since 2017/03/21
 *
 */
public class MyPageAction extends ActionSupport{
	/**
	 * お客様情報リスト
	 */
	private List<MyPageDTO> myInfo;
	/**
	 * ユーザーID
	 */
	private int userId;

	/** マイページの実行メソッド
	 * @author KONAKASAKA TOMOHIRO
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws NumberFormatException, SQLException{
		MyPageDAO dao = new MyPageDAO();
		myInfo = dao.select(userId);
		return SUCCESS;
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
	 * お客様情報リストを取得します。
	 * @return お客様情報リスト
	 */
	public List<MyPageDTO> getMyInfo() {
		return myInfo;
	}

	/**
	 * お客様情報リストを設定します。
	 * @param myInfo お客様情報リスト
	 */
	public void setMyInfo(List<MyPageDTO> myInfo) {
		this.myInfo = myInfo;
	}
}
