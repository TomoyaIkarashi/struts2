package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDTO;
import util.DBConnector;

/**
 * ログイン情報を取得するクラス
 * @author Kayoko Ueki
 * @since 2017/03/16
 * @version 1.1
 */
public class LoginDAO {

	LoginDTO dto = new LoginDTO();
	LoginDTO dto2 = new LoginDTO();
	PreparedStatement ps;
	String url = null;

	/**
	 * openconnectから情報を取得するメソッド
	 * @param phoneEmail アドレス
	 * @param password パスワード
	 * @return LoginDTO ログイン情報
	 */
	public LoginDTO select(String phoneEmail, String password){
		url = "openconnect";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();
		String sql = "select user_id, phone_email, login_flg, user_flg ,password "
				   + "from users where  phone_email = ? and password = ?";
		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2, password);
			ResultSet rs =ps.executeQuery();

			if(rs.next()){
				dto.setUserId(rs.getString("user_id"));
				dto.setPhoneEmail(rs.getString("phone_email"));
				dto.setLoginFlg(rs.getString("login_flg"));
				dto.setUserFlg(rs.getString("user_flg"));
				dto.setPassword(rs.getString("password"));
			}

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }
        System.out.println("select_"+"userId="+dto.getUserId()+",password="+dto.getPassword());
        return dto;
	}

	/**
	 * gochikagDBに顧客情報があるか確認するメソッド
	 * @param phoneEmail アドレス
	 * @param password パスワード
	 * @return count2 データの行数
	 */
	public int count (String phoneEmail, String password){
		url = "gochikag";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();
		int count2 = 0 ;
		String sql = "select count(*) count from users where phone_email = ? and password = ? ";

		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				count2 = rs.getInt("count");
			}
		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }System.out.println("count2="+count2);
        return count2;
	}
	/**
	 * GochikagDBのログインフラグをtrueにするメソッド
	 * @param phoneEmail アドレス
	 * @param password パスワード
	 * @return flg 更新できればtrue
	 */
	public int update(String phoneEmail, String password){

		url="gochikag";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();
		int flg = 0;
		String sql = "update users set login_flg = true where phone_email = ? and password = ?";
		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2,password);
			flg =ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        	ps.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }System.out.println("update_lFlg="+flg);
        return flg;
	}

	/**
	 * @param phoneEmail
	 * @param password
	 * @return
	 * openconnectのログインフラグをtrueにする
	 */
	public int update2(String phoneEmail, String password){

		url="openconnect";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();
		int flg2 = 0;

		String sql = "update users set login_flg = true where phone_email = ? and password = ?";

		try{
			ps= con.prepareStatement(sql);
			ps.setString(1, phoneEmail);
			ps.setString(2,password);

			flg2 =ps.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        	ps.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }System.out.println("update2_lFlg="+flg2);
        return flg2;
	}


	/**
	 * gochikagDBに情報をinsertするメソッド
	 * @param userId 顧客ID
	 * @param phoneEmail アドレス
	 * @param loginFlg ログインフラグ
	 * @param userFlg ユーザーフラグ
	 * @param password パスワード
	 * @return LoginDTO 入力された情報
	 *
	 */
	public LoginDTO insert(String userId, String phoneEmail, String loginFlg, String userFlg, String password){
		url="gochikag";
		DBConnector db = new DBConnector(url);
		Connection con =db.getConnection();
		int rs = 0;

		String sql = "insert into  users (user_id, phone_email, login_flg, user_flg, password) values (?, ?, ?, ?, ?)";

		try{
			ps= con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,phoneEmail);
			ps.setString(3,loginFlg);
			ps.setString(4,userFlg);
			ps.setString(5, password);
			rs =ps.executeUpdate();

			System.out.println(userId);

		}catch(SQLException e){
			e.printStackTrace();
        }try{
        	con.close();
        	ps.close();
        }catch(SQLException e){
        	e.printStackTrace();
        }System.out.println("insert");
        return dto;
	}

}