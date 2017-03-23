/**
 *
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.ItemDTO;
import util.DBConnector;

/**
 *
 * @author Tomohiro Konasaka
 * @since 2017/03/15
 * @version 1.1
 */
public class ItemDAO {
	/**
	 * 商品情報を取得するメソッド
	 * @param item_id 商品ID
	 * @return ItemDTO 商品情報
	 */
	public ItemDTO select(int item_id) {
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();

		ItemDTO dto = new ItemDTO();

		String sql = "select item_id, item_name, main_picture, price, detail_ja, stock_number, sub_picture1, sub_picture2, sub_picture3 "
				   + "from (item inner join detail using(item_id)) inner join pictures using(item_id) where item_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, item_id);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemName(rs.getString("item_name"));
			    dto.setMainPicture(rs.getString("main_picture"));
				dto.setDetailJa(rs.getString("detail_ja"));
				dto.setPrice(rs.getFloat("price"));
				dto.setStockNumber(rs.getInt("stock_number"));
				dto.setSubPicture1(rs.getString("sub_picture1"));
				dto.setSubPicture2(rs.getString("sub_picture2"));
				dto.setSubPicture3(rs.getString("sub_picture3"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

}
