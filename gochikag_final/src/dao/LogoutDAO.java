/**
 *
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.LoginDTO;
import util.DBConnector;

/**
 * @author internous
 *
 */
public class LogoutDAO {

	String url = null;
	int lFlg;
	int lFlg2;

	LoginDTO dto = new LoginDTO();
	LoginDTO dto2 = new LoginDTO();

	/**
	 * @param phoneEmail
	 * @param password
	 * @return
	 * gochikagDBのlogin_flgをfalseに更新
	 */
	public int update(String phoneEmail, String password){

		url="gochikag";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();

		String sql = "update users set login_flg = false where phone_email = ? and password = ?";

		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2,password);

			lFlg =ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }System.out.println("daoUp="+lFlg);
        return lFlg;
	}

	/**
	 * @param phoneEmail
	 * @param password
	 * @return
	 * openconnectのlogin_flgをfalseに更新
	 */
	public int update2(String phoneEmail, String password){

		url="openconnect";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();

		String sql = "update users set login_flg = false where phone_email = ? and password = ?";

		try{
			PreparedStatement ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2,password);

			lFlg2 =ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        return lFlg2;
	}
	/**
	 *
	 * @param itemId
	 * @param userId
	 * @return
	 * @throws SQLException
	 * gochikagDBのcartテーブルのデータの削除
	 */
	//
		public int delete(int userId) throws SQLException{
			url="gochikag";
			DBConnector db = new DBConnector(url);
			Connection con =db.getConnection();
			PreparedStatement ps = null;
			int rs=0;

			String sql="delete from cart where user_id = ? ";

			try{
				ps=con.prepareStatement(sql);
				ps.setInt(1,userId);

			}catch(SQLException e){
				e.printStackTrace();

			}finally{
				if(ps!=null) ps.close();
				if(con!=null) con.close();
			}
			return rs;
		}
}