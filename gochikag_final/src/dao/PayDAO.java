package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBConnector;

/**
 * カートフラグをtrueにするクラス
 * @author Junna Watanabe
 * @since 2017/03/15
 * @version 1.1
 */
public class PayDAO {

	/**
	 * カートフラグをtrueにするメソッド
	 * @param userId 顧客ID
	 * @return checkCartFlg 更新できたらtrue
	 * @throws SQLException
	 */
	public boolean update(int userId) throws SQLException{
		Connection con = new DBConnector("gochikag").getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update cart2 set cart_flg = true where user_id = ?";
		boolean checkCartFlag = false;

		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			con.setAutoCommit(false);
			rs = ps.executeUpdate();
			con.commit();
			if(rs != 0) checkCartFlag = true;

		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return checkCartFlag;
	}


}