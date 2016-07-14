import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adyachenko on 16.06.16.
 */
public class ReadDomains {

    public JSONObject fileRead(String filename) {
        String jsonData = "";
		BufferedReader br = null;
		try {
			String line;
			br = new BufferedReader(new FileReader(filename));
			while ((line = br.readLine()) != null) {
				jsonData += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
        JSONObject obj = new JSONObject(jsonData);

        return obj;
    }

    public ArrayList fillAcc (String filename) {
        String username;
        String email;
        JSONArray whmAccs;
        JSONArray domains;
        ArrayList <WHMAcc> whmArray = new ArrayList<>();
        whmAccs = fileRead(filename).getJSONArray("whmacc");
        for (Object whmacc : whmAccs) {
            JSONObject whm = new JSONObject(whmacc.toString());
//            System.out.println("host: " + whm.getString("host"));
            domains = whm.getJSONArray("domains");
            for (Object domain : domains) {
//			    System.out.println(domain);
                username = domain.toString().replaceAll("[-.]", "");
                if (username.substring(0, 1).matches("[0-9]"))
                    username = "a" + username;
                if (username.length() > 15)
                    username = username.substring(0,15);
                email = username + "@cwatchtest.com";
                whmArray.add(new WHMAcc(whm.getString("host"), username, domain.toString(), "GfHjkm11", email));
		    }
        }
        return whmArray;
    }

}
