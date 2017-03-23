package action;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import util.TwitterOauth;

/**
 * Twitterでログインする為のクラス
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class GoTwitterAction extends ActionSupport implements ServletResponseAware, ServletRequestAware {

    /**
     * シリアルID
     */
    private static final long serialVersionUID = 1524555947613444860L;

    /**
     * セッション
     */
    private Map<String, Object> session;

    /**
     * レスポンス
     */
    private HttpServletResponse response;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * TwitterリクエストTokenを取得するメソッド
     * @author MIYAGI KAZUNE
     * @return  result
     * @throws SQLException
     */
    public String execute() throws SQLException{
    	System.out.println("GOTWEEET");
        TwitterOauth twitterOauth = new TwitterOauth();
        if (!twitterOauth.getRequestToken(request, response)) {
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * セッションを格納するためのメソッド
     * @param session セッション
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    /**
     * セッションを取得するためのメソッド
     * @return session
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * レスポンスを格納するためのメソッド
     * @param response レスポンス
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    /**
     * リクエストを格納するためのメソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
}