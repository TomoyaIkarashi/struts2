package action;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.LoginOauthDAO;
import dto.LoginOauthDTO;
import util.TwitterOauth;

/**
 * Twitterでログインする為のクラス
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{

    /**
     * シリアルバージョンIDの生成
     */
    private static final long serialVersionUID = 3787626263699340105L;

    /**
     * ネットワークネーム
     */
    static final String NETWORK_NAME = "Twitter";

    /**
     * セッション
     */
    public Map<String, Object> session;

    /**
     * レスポンス
     */
    private HttpServletResponse response;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * Twitter認証の実行メソッド
     * @author MIYAGI KAZUNE
     * @return rtn
     * @throws SQLException
     */
    public String execute() throws SQLException{
    	System.out.println("LoginTWEEET");
        String rtn = ERROR;
        TwitterOauth twitterOauth = new TwitterOauth();
        String[] userData = new String[2];
        userData = twitterOauth.getAccessToken(request, response);

        if (userData == null) {
            return rtn;
        }

        String uniqueId = userData[0];
        String userName = userData[1];
        LoginOauthDAO dao = new LoginOauthDAO();
        if (dao.select(uniqueId, NETWORK_NAME)) {
            LoginOauthDTO dto = dao.getLoginOauthDTO();
            session.put("loginId", dto.getUserId());
            session.put("userName", dto.getUserName());
            rtn = SUCCESS;
            return rtn;
        }

        boolean result = dao.insert(uniqueId, userName, NETWORK_NAME);
        if (!result) {
            return rtn;
        }

        dao.select(uniqueId, NETWORK_NAME);
        LoginOauthDTO dto = dao.getLoginOauthDTO();
        session.put("loginId", dto.getUserId());
        session.put("userName", dto.getUserName());
        rtn = SUCCESS;
        return rtn;
    }

    /**
     * レスポンス格納メソッド
     * @param response レスポンス
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエスト格納メソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * セッション格納メソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッション取得メソッド
     * @return Session
     */
    public Map<String, Object> getSession() {
        return session;
    }
}
