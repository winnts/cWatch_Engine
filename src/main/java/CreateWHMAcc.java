import Const.Credentials;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adyachenko on 05.05.16.
 */
public class CreateWHMAcc {

    public ArrayList fillAcc (){
        ArrayList <WHMAcc> whmAccs = new ArrayList<>();

//10.8.3.18
        whmAccs.add(new WHMAcc("censor", "censor.net", "FGFfdsf7823467"));
        whmAccs.add(new WHMAcc("media", "media.info", "FGFfdsf7823467"));
        whmAccs.add(new WHMAcc("rulez", "rulez.ua", "FGFfdsf7823467"));
        whmAccs.add(new WHMAcc("spammm", "spamchick.net", "FGFfdsf7823467"));
        whmAccs.add(new WHMAcc("candy", "candys.tv", "FGFfdsf7823467"));
        whmAccs.add(new WHMAcc("hubin", "hubyourlife.com", "FGFfdsf7823467"));




//10.8.3.17
//        whmAccs.add(new WHMAcc("newlife", "newlife.com.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("boxing", "boxing.ru", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("rollall", "rollallday.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("rhcp", "rhcp.tv", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("chicago", "chicago.news", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("smile", "bestmoments.com", "FGFfdsf7823467"));

//10.8.3.15
//        whmAccs.add(new WHMAcc("firmhouse", "firmhouse.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("tldp", "tldp.org", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("superuser", "superuser.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("json", "json.org", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("stackoverflow", "stackoverflow.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("github", "github.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("beginnersbook", "beginnersbook.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("blogbdoughan", "blog.bdoughan.com", "FGFfdsf7823467"));
//10.8.3.11
//        whmAccs.add(new WHMAcc("b52", "b-52.net", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("iua", "i.ua", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("newsproj", "news.projects.april.com", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("search", "search.job1.05042016.work.info", "FGFfdsf7823467"));
//10.8.3.12
//        whmAccs.add(new WHMAcc("mailnet", "mail.net", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("org42org", "42.org", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("ifyou", "ifyouwantbuyacaryoushouldcallmefirstandyouwillbehappy.net", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("serchjob1", "search.job1.05042016.work.info", "FGFfdsf7823467"));
//10.8.3.14
//        whmAccs.add(new WHMAcc("deep", "deep.net", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("info12365i", "12.365.info", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("avail", "availablecar.bestcarmarketintheworld.biz", "FGFfdsf7823467"));
//        whmAccs.add(new WHMAcc("shopso", "shops.odessa.i.ua", "FGFfdsf7823467"));


        return whmAccs;
    }

    public static void main(String[] args) throws IOException{
        CreateWHMAcc createWHMAcc = new CreateWHMAcc();
        ArrayList <WHMAcc> whmAccs;
        whmAccs = createWHMAcc.fillAcc();
        for (WHMAcc whmAcc : whmAccs) {
            System.out.println("Adding acc: " + whmAcc.user);
            System.out.println(Requester.post(Connection.AuthorizedConnect(Connection.HttpsConnection("https://cwatch8.test.com:2087/json-api/createacct?"), new Credentials().getUser(), new Credentials().getPass()), "username="+whmAcc.user+"&domain="+whmAcc.domain+"&password="+whmAcc.passwd));
        }

    }

}
