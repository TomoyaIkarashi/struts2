package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.CartSelectDTO;
import util.DBConnector;

/**
 * カート情報を取得するクラス
 * @author Kazune Miyagi
 * @since 2017/03/15
 * @version 1.1
 */
public class CartSelectDAO {
	//selectメソッド構成
	/**
	 * カート取得するメソッド
	 * @param userId 顧客ID
	 * @return カート情報
	 * @throws SQLException
	 */
	public List<CartSelectDTO> select(int userId) throws SQLException{

		//フィールド
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		CartSelectDTO dto;
		List<CartSelectDTO> dtoList = new ArrayList<>();
		PreparedStatement ps=null;
		String sql="select item_id, item_name, price, item_count, amount, stock_number from item "
				+ "inner join cart2 using(item_id) where user_id=?";

		try{
			ps=con.prepareStatement(sql);
			ps.setInt(1,userId);
			ResultSet rs=ps.executeQuery();
			int index = 0;

			while(rs.next()){
				dto = new CartSelectDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setItemCount(rs.getInt("item_count"));
				dto.setAmount(rs.getInt("amount"));
				dto.setStockCount(rs.getInt("stock_number"));
				dto.setIndex(index);
				dtoList.add(dto);
				index ++;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return dtoList;
	}

}
