import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by adyachenko on 25.04.16.
 */
public class Connection {
    public static HttpURLConnection HttpConnection (String url) throws IOException {
        URL u = new URL (url);
        return (HttpURLConnection)u.openConnection();
    }

    public static HttpsURLConnection HttpsConnection (String url) throws IOException {
        URL u = new URL (url);
        return (HttpsURLConnection)u.openConnection();
    }

    public static HttpsURLConnection AuthorizedConnect (HttpsURLConnection con, String login, String pass) throws IOException {
        String userpass = login + ":" + pass;
        String basicAuth = "Basic " + new String(new Base64().encode(userpass.getBytes()));
        con.setRequestProperty("Authorization", basicAuth);
        return con;
    }
}
