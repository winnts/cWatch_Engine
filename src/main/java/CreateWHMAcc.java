import Const.Credentials;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adyachenko on 05.05.16.
 */
public class CreateWHMAcc {


    public static void main(String[] args) throws IOException{
        ReadDomains getDomains = new ReadDomains();
        ArrayList <WHMAcc> whmAccs;
        whmAccs = getDomains.fillAcc("domains11.json");
        for (WHMAcc whmAcc : whmAccs) {
            System.out.println("Adding acc: " + whmAcc.user + " to host: " + whmAcc.host);
            System.out.println(Requester.post(Connection.AuthorizedConnect(Connection.HttpsConnection("https://"+whmAcc.host+":2087/json-api/createacct?"),
                    new Credentials().getUser(), new Credentials().getPass()),
                    "username="+whmAcc.user+"&domain="+whmAcc.domain+"&password="+whmAcc.passwd+"&contactemail="+whmAcc.email));
            System.out.println("##########################################################");
        }
    }
}
