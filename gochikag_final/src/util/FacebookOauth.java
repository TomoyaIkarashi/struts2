package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;

import com.opensymphony.xwork2.ActionSupport;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;
/**
* FACEBOOK OAuthでログインする為のクラス
* @author MIYAGI KAZUNE
* @since 1.0
* @version 1.0
*/
public class FacebookOauth extends ActionSupport {

   /**
    * 生成されたシリアルナンバー
    */
   private static final long serialVersionUID = -564268116563098912L;

   /**
    * APP ID
    */
   private static final String APP_ID = "262769587483198";

   /**
    * レスポンスURL
    */
   private static final String APP_SECRET = "7d29c7a3b059dbc6f3fefbdb75cd54c1";

   /**
    * コールバックパス
    */
   private static final String CALLBACK_PATH = "/LoginFacebookAction";

   /**
    * ユーザー情報を取得するメソッド
    * @param request リクエスト
    * @param response レスポンス
    */
   public void getRequestToken(HttpServletRequest request, HttpServletResponse response) {
       Facebook facebook = new FacebookFactory().getInstance();
       request.getSession().setAttribute("facebook", facebook);
       facebook.setOAuthAppId(APP_ID, APP_SECRET);
       String accessTokenString = APP_ID + "|" + APP_SECRET;
       AccessToken at = new AccessToken(accessTokenString);
       facebook.setOAuthAccessToken(at);
       StringBuffer callbackURL = request.getRequestURL();

       System.out.println("callbackURL");
       System.out.println(callbackURL);

       int index = callbackURL.lastIndexOf("/");
       callbackURL.replace(index, callbackURL.length(), "").append(CALLBACK_PATH);
       try {
           response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   /**
    * アクセストークンの取得メソッド
    * @param request リクエスト
    * @param response レスポスト
    * @return userMap ユーザー情報
    */
   public Map<String, String> getAccessToken(HttpServletRequest request, HttpServletResponse response){
       final String callbackURL = request.getRequestURL().toString();
       final String code = request.getParameter("code");
       if(code == null){
           try {
        	   System.out.println(request.getContextPath()+ "/login");
               response.sendRedirect(request.getContextPath()+ "/login");
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       String accessTokenURL = null;
       try {
           accessTokenURL = "https://graph.facebook.com/oauth/access_token?client_id="
                   + APP_ID
                   + "&redirect_uri="
                   + URLEncoder.encode(callbackURL, "UTF-8")
                   + "&client_secret="
                   + APP_SECRET
                   + "&code="
                   + URLEncoder.encode(code, "UTF-8");

           System.out.println(accessTokenURL);
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       String accessTokenResult = null;
       try {
           accessTokenResult = httpRequest(new URL(accessTokenURL));
       } catch (MalformedURLException e1) {
           e1.printStackTrace();
       }

       String accessToken = null;
       String[] pairs = accessTokenResult.split("&");
       for (String pair : pairs) {
           String[] kv = pair.split("=");
           if (kv.length != 2) {
               throw new RuntimeException("Unexpected auth response");
           } else {
               if (kv[0].equals("access_token")) {
                   accessToken = kv[1];
               }
           }
       }
       String apiURL = null;
       try {
           apiURL = "https://graph.facebook.com/me?access_token="
                   + URLEncoder.encode(accessToken, "UTF-8");
       } catch (UnsupportedEncodingException e) {
           e.printStackTrace();
       }
       String apiResult = null;
       try {
           apiResult = httpRequest(new URL(apiURL));
       } catch (MalformedURLException e) {
           e.printStackTrace();
       }
       @SuppressWarnings("unchecked")
       Map<String, String> userMap = (Map<String, String>) JSONValue.parse(apiResult);
       return userMap;
   }

   /**
    * リクエスト用メソッド
    * @param url URL
    * @return String
    */
   private String httpRequest(URL url) {
       HttpURLConnection conn = null;
       String response = "";
       try {
           conn = (HttpURLConnection) url.openConnection();
           conn.setDoOutput(true);
           conn.setUseCaches(false);
           conn.setRequestMethod("GET");
           BufferedReader reader = new BufferedReader(new InputStreamReader(
                   conn.getInputStream()));
           String line = null;

           while ((line = reader.readLine()) != null) {
               response += line;
           }
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           conn.disconnect();
       }
       return response;
   }

}
