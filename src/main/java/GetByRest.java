import org.codehaus.jackson.type.TypeReference;

import java.util.ArrayList;

/**
 * Created by adyachenko on 27.04.16.
 */
public class GetByRest {
    public static ArrayList<ResellerObj> getResellers (String json){
        ArrayList<ResellerObj> resellers;
        resellers = JsonUtils.fromJson(json, new TypeReference<ArrayList<ResellerObj>>(){});
//        for (ResellerObj resellerObj : resellers) {
//            for (Reseller reseller : resellerObj.resellers) {
//                System.out.println("ID :" + reseller.id);
//                System.out.println("Created :" + reseller.created_at);
//                System.out.println("Login :" + reseller.login);
//                System.out.println("-------------------------");
//            }
//        }
        return resellers;
    }
    public static ArrayList<Reseller> getResellerById (String json) {
        ArrayList<Reseller> reseller;
        reseller = JsonUtils.fromJson(json, new TypeReference<ArrayList<Reseller>>(){});
        return reseller;
    }

}
