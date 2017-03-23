package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import dto.UsersDTO;
import util.DBConnector;

/**
 * Oauthでログインに必要な情報を取得する為のクラス
 * @author Kazune Miyagi
 * @since 2017/3/17
 * @version 1.1
 */
public class LoginOauthDAO {
	/**
	 * 取得した情報を格納する為のDTO
	 */
	private UsersDTO dto = new UsersDTO();
	/**
	 * 取得したユニークIDを照合する為のメソッド
	 * @param userUniqueId OAuthのサービス先ユニークID
	 * @param oauthName OAuthのサービス名
	 * @return result
	 */
	public UsersDTO select(String oauthId,String oauthAccount){
		boolean result = false;
		//String option = "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
		Connection con = new DBConnector("gochikag").getConnection();
		String sql = "SELECT * FROM users WHERE oauth_id = ? AND oauth_account = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,oauthId);
			ps.setString(2,oauthAccount);
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				dto.setUserId(rs.getInt("user_id"));
				dto.setLoginFlg(rs.getBoolean("login_flg"));
				dto.setOauthId(rs.getString("oauth_Id"));
				dto.setOauthAccount(rs.getString("oauth_account"));
				dto.setAlredyUser(true);
				result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return dto;
	}

	/**
	 * OAuth認証が初めてならユーザー情報を追加するメソッド
	 * @param oauthId OAuthのサービス先ユニークID
	 * @param oauthAccount Oauthのサービス先ユーザー名
	 * @param oauthName OAuthのサービス名
	 * @return result 結果
	 */
	public boolean insert(String oauthId,String oauthAccount,int oauthName){
		System.out.println("INSERT");
		String option = "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
		Connection con = new DBConnector("gochikag" + option).getConnection();
		boolean result = false;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String now = sdf.format(cal.getTime());
		String sql = "INSERT INTO users(oauth_id, oauth_account,oauth_name, register_day, update_day) values(?,?,?,?,?)";

		try{
			System.out.println("SQL1");
			PreparedStatement ps = con.prepareStatement(sql);
			System.out.println("SQL2");
			ps.setString(1,oauthId);
			ps.setString(2,oauthAccount);
			ps.setInt(3,oauthName);
			ps.setString(4,now);
			ps.setString(5,now);
			System.out.println(ps);

			int insertCount = ps.executeUpdate();
			if(insertCount > 0){
				result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * falseからtrueにログインフラグのアップデートを行う
	 * @param userId ユーザーId
	 * @param loginFlg ユーザーのログイン状況
	 * @return count 実行件数
	 * @throws SQLException エラー処理
	 */

	public int update(int userId,int loginFlg) throws SQLException{
		int count = 0;
		//String option = "?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
		Connection con = new DBConnector("gochikag").getConnection();
		String sql = "UPDATE users SET login_flg = ? where user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, loginFlg);
			ps.setInt(2, userId);
			count = ps.executeUpdate();
			System.out.println("count");
			System.out.println(count);
			return count;
		}catch(SQLException e){
			e.printStackTrace();}
			finally{con.close();
		}
		return count;
	}
}