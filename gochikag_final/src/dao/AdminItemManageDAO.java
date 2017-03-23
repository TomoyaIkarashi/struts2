package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.ItemDTO;
import util.DBConnector;

/**
* @author Yoshikazu Sakamoto
* @since 2017/03/13
* @version 1.1
*/
public class AdminItemManageDAO {
	//public ArrayList<ItemDTO> searchList = new ArrayList<ItemDTO>();

	/**
	 *
	 * @param item_name
	 * @param item_id
	 * @return nameList
	 */

	public ArrayList<String> select1(String category) {
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		ArrayList<String> nameList = new ArrayList<String>();

		String sql = "select item_name from item where category = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,category);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				nameList.add(rs.getString("item_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nameList;
	}

	/**
	 * @param itemName 
	 * @return
	 * @throws SQLException 
	 */
	public ItemDTO select2(String itemName) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		ItemDTO dto = new ItemDTO();
		PreparedStatement ps = null;
		String sql = "select item_name,item_id,price,stock_number from item where item_name = ? ";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setStockNumber(rs.getInt("stock_number"));
				dto.setItemFlg(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return dto;
	}

	/**
	 * @param itemId 
	 * @param stockNumber 
	 * @return
	 * @throws SQLException 
	 */
	public int update(int itemId, int stockNumber) throws SQLException{
		//フィールド
		DBConnector db=new DBConnector("gochikag");
		Connection con=db.getConnection();
		PreparedStatement ps = null;
		int rs=0;
		String sql="update item set stock_number = ? where item_id = ?";
		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1,stockNumber);
			ps.setInt(2, itemId);
			con.setAutoCommit(false);
			rs=ps.executeUpdate();
			con.commit();
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		} finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return rs;
	}

	public int deleteFromDetail(int itemId,int userId) throws SQLException{

		//フィールド
		DBConnector db=new DBConnector("gochikag");
		Connection con=db.getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		String sql="delete from cart2 where user_id=? and item_id=?";

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1,userId);
			ps.setInt(2,itemId);
			con.setAutoCommit(false);
			rs=ps.executeUpdate();
			con.commit();
			System.out.println("CartDeleteDAO");
		}catch(SQLException e){
			con.rollback();
			e.printStackTrace();
		}finally{
			if(ps!=null) ps.close();
			if(con!=null) con.close();
		}
		return rs;
	}

}
