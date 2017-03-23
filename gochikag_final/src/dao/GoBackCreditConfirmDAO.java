package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnector;
/**
 * credit_flgを解除するクラス
 * @author Ai Yoneshima
 * @since 2017/03/16
 * @version 1.1
 */
public class GoBackCreditConfirmDAO {

	/**
	 * credit_flgをfalseにするメソッド
	 * @param userId 顧客ID
	 * @return checkFlg 解除できたらfalse
	 */
	public boolean update(int userId){
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "update cart2 set credit_flg = false where user_id = ?";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0){
				checkFlag = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return checkFlag;
	}
}