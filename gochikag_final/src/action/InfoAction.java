package action;

import java.sql.SQLException;

import com.opensymphony.xwork2.ActionSupport;

import dao.InfoDAO;

/**
 *問い合わせする為のアクション
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class InfoAction extends ActionSupport{

	/**
	 * 名前
	 */
	private String name;
	/**
	 * Eメール
	 */
	private String email;
	/**
	 * 問い合わせ内容
	 */
	private String info;


	/**
	 *  実行メソッド 問い合わせをDBに入れる
	 * @author MIYAGI KAZUNE
	 * @return result
	 * @throws SQLException
	 */
	public String execute() throws SQLException{
		InfoDAO dao = new InfoDAO();
		int dto = 0;
		dto = dao.insert(name,email,info);

		if(dto == 0){
			return ERROR;
		}else{
			return SUCCESS;
		}
	}


	/**
	 * 名前を取得します。
	 * @return 名前
	 */
	public String getName() {
		return name;
	}


	/**
	 * 名前を設定します。
	 * @param name 名前
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Eメールを取得します。
	 * @return Eメール
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Eメールを設定します。
	 * @param email Eメール
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * 問い合わせ内容を取得します。
	 * @return 問い合わせ内容
	 */
	public String getInfo() {
		return info;
	}


	/**
	 * 問い合わせ内容を設定します。
	 * @param info 問い合わせ内容
	 */
	public void setInfo(String info) {
		this.info = info;
	}

}