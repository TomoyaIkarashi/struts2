package util;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

 /**
 *TwitterでのOAuthでログインする為のクラス
 * @author MIYAGI KAZUNES
 * @since 1.0
 * @version 1.0
 */
public class TwitterOauth {

    /**
    * 結果
    */
    private boolean result=false;

    /**
    * コンシューマーキー
    */
    private final String CONSUMER_KEY = "XxN2epi4KvvypmLU0PthRlSJE";

    /**
    * コンシューマーシークレット
    */
    private final String CONSUMER_SECRET = "nUs246mJMLmgs5ilgZ71ktBIiRqxpYkSQ3H4P3k2SqF7Q1ULbr";
    private static TwitterFactory twitterFactory = new TwitterFactory();

    /**
     * ユーザー情報を取得するメソッド
     * @param request リクエスト
     * @param response  レスポンス
     * @return map ユーザー情報
     */
    public boolean getRequestToken(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("OauthREQ");
        Twitter twitter = twitterFactory.getInstance();
        twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        try{
            RequestToken reqToken = twitter.getOAuthRequestToken();
            HttpSession session = request.getSession();
            session.setAttribute("RequestToken", reqToken);
            session.setAttribute("Twitter", twitter);
            String strUrl = reqToken.getAuthorizationURL();
            response.sendRedirect(strUrl);
        }catch (TwitterException | IOException e){
        }
        return result;
    }


    /**
     * @param request リクエスト
     * @param response レスポンス
     * @return userMap ユーザー情報
     */
    public String[] getAccessToken(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("OauthAccess");
        HttpSession session = request.getSession();
        Twitter twitter = (Twitter) session.getAttribute("Twitter");
        String verifier = request.getParameter("oauth_verifier");
        if(verifier == null){
            try {
                response.sendRedirect(request.getContextPath()+ "/login");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AccessToken accessToken = null;

        try {
            if (session.getAttribute("RequestToken") != null) {
                accessToken = twitter.getOAuthAccessToken( (RequestToken) session.getAttribute("RequestToken"), verifier);
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
        if (accessToken != null) {
            session.setAttribute("AccessToken", accessToken.getToken());
            session.setAttribute("AccessTokenSecret", accessToken.getTokenSecret());
        }
        User user = null;
        try {
            user = twitter.verifyCredentials();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        String[] userData = new String[2];
        userData[0] = user.getScreenName();
        userData[1] = user.getName();

        return userData;
    }
}
