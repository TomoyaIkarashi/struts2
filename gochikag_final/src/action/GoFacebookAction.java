
package action;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import util.FacebookOauth;

/**
 * FACEBOOKでログインする為のクラス
 * @author MIYAGI KAZUNE
 * @since 2017/03/21
 * @version 1.1
 */
public class GoFacebookAction  extends ActionSupport implements ServletResponseAware,ServletRequestAware  {

    /**
     * 生成されたシリアルナンバー
     */
    private static final long serialVersionUID = 8410788671527276072L;

    /**
     * リクエスト
     */
    private HttpServletRequest request;

    /**
     * レスポンス
     */
    private HttpServletResponse response;
    /**
     * FaceBookからTokenを取得するメソッド
     * @author MIYAGI KAZUNE
     * @return result
     * @throws SQLException
     */
    public String execute() throws SQLException{
    	System.out.println("GoFacebookAction");
        FacebookOauth oauth = new FacebookOauth();
        oauth.getRequestToken(request, response);
        return SUCCESS;
    }

    /**
     * リクエスト格納メソッド
     * @param request リクエスト
     */
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    /**
     * レスポンス格納メソッド
     * @param response レスポンス
     */
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }
}