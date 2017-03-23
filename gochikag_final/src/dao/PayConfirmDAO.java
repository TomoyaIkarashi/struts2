package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.PayConfirmDTO;
import util.DBConnector;

/**
 * 購入手続きを完了するクラス
 * @author Kazune Miyagi
 * @since 2017/03/16
 * @version 1.1
 */
public class PayConfirmDAO {

	/**
	 * confirm_flgをtrueにするメソッド
	 * @param userId 顧客ID
	 * @return checkFlg 処理が出来たらtrue
	 * @throws SQLException
	 */
	public boolean updateConfirmFlg(int userId) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "update cart2 set confirm_flg = true where user_id = ?";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return checkFlag;
	}

	/**
	 * カート情報を取得するメソッド
	 * @param userId 顧客ID
	 * @return ArrayList<PayConfirmDTO> カート情報
	 * @throws SQLException
	 */
	public ArrayList<PayConfirmDTO> selectCartData(int userId) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		PayConfirmDTO dto = null;
		ArrayList<PayConfirmDTO> dtoList = new ArrayList<PayConfirmDTO>();
		String sql = "select item_id, item_count, amount from cart2 where user_id = ?";
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				dto = new PayConfirmDTO();
				dto.setItemId(rs.getInt("item_id"));
				dto.setItemCount(rs.getInt("item_count"));
				dto.setAmount(rs.getInt("amount"));
				dtoList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return dtoList;
	}

	/**
	 * 購入履歴を更新するメソッド
	 * @param itemId 商品ID
	 * @param userId 顧客ID
	 * @param itemCount 商品数
	 * @param amount 合計金額
	 * @param now 購入日
	 * @return checkFlg 更新できたらtrue
	 * @throws SQLException
	 */
	public boolean insertIntoPurchase(int itemId, int userId, int itemCount, int amount, String now) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into purchase2(item_id, user_id, item_count, amount, purchase_day) values(?, ?, ?, ?, ?)";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setInt(2, userId);
			ps.setInt(3, itemCount);
			ps.setInt(4, amount);
			ps.setString(5, now);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return true;
	}

	/**
	 * クレジット情報を更新するメソッド
	 * @param userId 顧客ID
	 * @param cardBrand カード会社
	 * @param nameE 名義
	 * @param loginId ログインID
	 * @param firstSixDigits カードの上6桁
	 * @param amount 合計金額
	 * @param now 購入日
	 * @return checkFlg 更新できたらtrue
	 * @throws SQLException
	 */
	public boolean insertIntoCredit(int userId, String cardBrand, String nameE, String loginId, String firstSixDigits, int amount, String now) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into credit2(user_id, card_brand, name_e, login_id, first_six_digits, amount, use_day) values(?, ?, ?, ?, ?, ?, ?)";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, cardBrand);
			ps.setString(3, nameE);
			ps.setString(4, loginId);
			ps.setString(5, firstSixDigits);
			ps.setInt(6, amount);
			ps.setString(7, now);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return true;
	}

	/**
	 * カード会社の購入履歴を更新するメソッド
	 * @param cardBrand カード会社
	 * @param loginId ログインID
	 * @param now 購入日
	 * @param amount 合計金額
	 * @param nameE 名義
	 * @param lastName 名
	 * @param firstName 姓
	 * @return checkFlg 更新できたらtrue
	 * @throws SQLException
	 */
	public boolean insertIntoUserHistroy(String cardBrand, String loginId, String now, int amount, String nameE, String lastName, String firstName) throws SQLException{
		DBConnector db = new DBConnector(cardBrand);
		Connection con = db.getConnection();
		String sql = null;
		PreparedStatement ps = null;
		if(cardBrand.equals("visa")){
			sql = "insert into user_history(login_id, office_name, use_day, payment_day, spend, payment, last_name, first_name) values(?, ?, ?, ?, ?, ?, ?, ?)";
		}else{
			sql = "insert into user_history(login_id, office_name, use_day, payment_day, spend, payment, name_e) values(?, ?, ?, ?, ?, ?, ?)";
		}
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, "gochikag");
			ps.setString(3, now);
			ps.setString(4, now);
			ps.setInt(5, amount);
			ps.setInt(6, amount);

			if(cardBrand.equals("visa")){
				ps.setString(7, lastName);
				ps.setString(8, firstName);
			}else{
				ps.setString(7, nameE);
			}

			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;

		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return true;
	}
	/**
	 * 商品数を更新するメソッド
	 * @param itemId 商品ID
	 * @param itemCount 商品数
	 * @return checkFlg 更新できたらtrue
	 * @throws SQLException
	 */
	public boolean updateItemStock(int itemId, int itemCount) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "update item set stock_number = stock_number - ? where item_id = ?";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemCount);
			ps.setInt(2, itemId);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return checkFlag;
	}

	/**
	 * カート情報を削除するメソッド
	 * @param itemId 商品Id
	 * @param userId 顧客ID
	 * @return checkFlg 削除できたらtrue
	 * @throws SQLException
	 */
	public boolean deleteCartData(int itemId, int userId) throws SQLException{
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from cart2 where item_id = ? and user_id = ?";
		int checkDigit = 0;
		boolean checkFlag = false;
		try{
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setInt(2, userId);
			checkDigit = ps.executeUpdate();
			if(checkDigit != 0) checkFlag = true;
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(ps != null) ps.close();
			if(con != null) con.close();
		}
		return checkFlag;
	}
}
