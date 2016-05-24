import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by adyachenko on 19.04.16.
 */

public class Requester {

    public static String get(HttpsURLConnection con) throws IOException {
        String content = "";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                content += line;
            }
        }
        return content;
    }

    public static String get(HttpURLConnection con) throws IOException {
        String content = "";
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String line;
            while ((line = in.readLine()) != null) {
                content += line;
            }
        }
        return content;
    }

    public static String post1(String address) throws IOException {
        URL url = new URL(address);
        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        try(DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            String params ="";
//                    "login=root" +  "" +
//                            "&password=GfHjkm11";
////                            + "" +
////                            "&size=10" +
////                            "&date=" + "";
            wr.writeBytes(params);
        }
        String ret = "";
        try(InputStream inputStream = con.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                ret += line;
            }
        }
        return ret;
    }

    public static String post (HttpsURLConnection con, String postData) throws IOException {
        String content = "";
        con.setDoOutput(true);
        con.setHostnameVerifier((hostname, session) -> true);
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//            String postData ="";
            wr.writeBytes(postData);
        }
        try(InputStream inputStream = con.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }
        }
        return content;

    }



    public static String post (HttpURLConnection con, String postData) throws IOException {
        String content = "";
        con.setDoOutput(true);
        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//            String postData ="";
            wr.writeBytes(postData);
        }
        try(InputStream inputStream = con.getInputStream()) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }
        }
        return content;

    }

    public static String parseJson (String object, String objToParse) throws JSONException {
        JSONObject obj = new JSONObject (object);
        String name = obj.getString(objToParse);
        System.out.println(name);
        return name;
    }

    public static JSONObject parseJsonObj (String object, String objToParse) throws JSONException {
        JSONObject obj = new JSONObject(object);
//        JSONObject outObj = new JSONObject(obj.getString(objToParse));
        return obj;
    }


    public static void main(String[] args) throws IOException, JSONException {
        ArrayList<ArrayList<String>> elements = new ArrayList<ArrayList<String>>();
//        ArrayList<ResellerObj> resellers = new ArrayList<>();
        ArrayList<Reseller> resellerOne = new ArrayList<>();
        ArrayList<ResellerPost> reseller = new ArrayList<>();

//        System.out.println(get(AuthorizedConnect(HttpsConnection("https://cwatch.test.com:2087/json-api/listaccts?api.version=1"), "root", "GfHjkm11")));
//        parseJsonArray(get(AuthorizedConnect(HttpsConnection("https://cwatch.test.com:2087/json-api/listaccts?api.version=1"), "root", "GfHjkm11")), "acct", "domain");
//        System.out.println(get(HttpConnection("http://api.cwatch.com/resellers")));
//        parseJson(get(HttpConnection("http://api.cwatch.com/users")));
//        System.out.println(parseJsonObj(get(HttpConnection("http://10.32.18.31:9200/_cluster/state?pretty"))), "");

//        resellers = GetByRest.getResellers(get(Connection.HttpConnection("http://api.cwatch.com/resellers")));
//        for (ResellerObj resellerObj : resellers) {
//            for (Reseller reseller : resellerObj.resellers) {
//                System.out.println("ID :" + reseller.id);
//                System.out.println("Created :" + reseller.created_at);
//                System.out.println("Login :" + reseller.login);
//                System.out.println("-------------------------");
//            }
//        }

//        resellerOne = GetByRest.getResellerById(get(Connection.HttpConnection("http://api.cwatch.com/resellers/fuck")));
//        for (Reseller reseller : resellerOne) {
//            System.out.println(reseller.id);
//            System.out.println(reseller.login);
//            System.out.println(reseller.created_at);
//            System.out.println("-------------------------");
//        }
//        resellerOne.add(new Reseller("Vasya", "Vasya Pupkin", "vasya.pupkin@gmail.com", "v.pupkin"));

//
//        reseller.add(new ResellerPost());
//        for (ResellerPost resellerPost : reseller) {
//            resellerPost.reseller.add(new Reseller("Vasya", "Vasya Pupkin", "vasya.pupkin@gmail.com", "v.pupkin"));
//        }
//        String jsonReseller = JsonUtils.toJson(reseller.get(0));
//        System.out.println(jsonReseller);

        ResellerPost resellerPost = new ResellerPost(resellerOne);
        resellerPost.addResellerPost(new Reseller("Vasya", "Vasya Pupkin", "vasya.pupkin@gmail.com", "v.pupkin"));
        String resellerPostJson = JsonUtils.toJson(resellerPost);
        System.out.println(resellerPostJson);

        resellerOne.add(new Reseller("Vasya", "Vasya Pupkin", "vasya.pupkin@gmail.com", "v.pupkin"));
        String resellerPostSingle = JsonUtils.toJson(resellerOne.get(0));
        System.out.println(resellerPostSingle);
//        post(Connection.HttpConnection("http://api.cwatch.com/resellers"), jsonReseller);


//        elements = parseJsonArray(get(Connection.HttpConnection("http://api.cwatch.com/resellers")), ResellerConst.OBJECT_NAME, parseElements);


//        resellers = JsonUtils.fromJson("[{\"id\":2,\"login\":\"chewbacca 1\"},{\"id\":5,\"login\":\"User\"}]", new TypeReference<ArrayList<Reseller>>(){});

//        System.out.println(elements);
//        for (ArrayList<String> element : elements) {
//            Object[] arrayObj = element.toArray();
//            String[] array = Arrays.copyOf(arrayObj, 8, String[].class);
//            resellers.add(new Reseller(array));
//        }
//        for (Reseller reseller : resellers) {
//            System.out.println(reseller.id);
//        }

    }
}



