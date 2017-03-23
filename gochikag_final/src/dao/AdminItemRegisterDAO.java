package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBConnector;

/**
 * 
 * @author Tomohiro Konasaka
 * @since 2017/03/13
 * @version 1.1
 * 
 */

public class AdminItemRegisterDAO {
	/**
	 * 商品情報を格納するメソッド
	 * @param itemName 商品名
	 * @param price 商品価格
	 * @param stockNumber 在庫数 
	 * @param mainPicture 商品画像
	 * @param now 格納時間
	 * @param category 商品分類
	 * @return rs 格納結果
	 */
	public int insertIntoItem(String itemName, float price, int stockNumber, String mainPicture, String now, String category){
		System.out.println("insertIntoItem");
		
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into item(item_name, price, stock_number, main_picture, registration_date, updated_date, category) "
				   + "values(?,?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			ps.setFloat(2, price);
			ps.setInt(3, stockNumber);
			ps.setString(4, mainPicture);
			ps.setString(5, now);
			ps.setString(6, now);
			ps.setString(7, category);
			rs = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	/**
	 * 商品IDを取得するメソッド
	 * @return itemId 商品ID
	 */
	public int select(){
	   System.out.println("select");
	   DBConnector db = new DBConnector("gochikag");
	   Connection con = db.getConnection();
	   PreparedStatement ps = null;
	   String sql = "select max(item_id) from item";
       int itemId = 0;
	   try{
		  ps = con.prepareStatement(sql);
		  ResultSet rs = ps.executeQuery();
		  if(rs.next()) itemId = rs.getInt("max(item_id)");
		} catch (SQLException e) {
			e.printStackTrace();
		} try {
			if(ps != null) ps.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemId;
	 }
	
	/**
	 * 商品詳細画像を格納するメソッド
	 * @param itemId 商品ID
	 * @param subPicture1 商品詳細画像1
	 * @param subPicture2 商品詳細画像2
	 * @param subPicture3 商品詳細画像3
	 * @return rs 格納結果
	 */
	public int insertIntoPictures(int itemId, String subPicture1, String subPicture2, String subPicture3){
		System.out.println("insertIntoPictures");
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into pictures(item_id, sub_picture1, sub_picture2, sub_picture3) values (?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1,  itemId);
			ps.setString(2, subPicture1);
			ps.setString(3, subPicture2);
			ps.setString(4, subPicture3);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null)	con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
        return rs;
	}
	
	/**
	 * 商品詳細情報を格納するメソッド
	 * @param itemId 商品ID
	 * @param detailJa 日本語の商品詳細説明
	 * @param detailEn 英語の商品詳細説明
	 * @return rs 格納結果
	 */
	public int insertIntoDetail(int itemId, String detailJa, String detailEn){
		System.out.println("insertIntoDetail");
		DBConnector db = new DBConnector("gochikag");
		Connection con = db.getConnection();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into detail(item_id, detail_ja, detail_en) values (?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemId);
			ps.setString(2, detailJa);
			ps.setString(3, detailEn);
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null)	con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
}
