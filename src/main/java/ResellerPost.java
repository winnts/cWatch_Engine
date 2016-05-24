import java.util.ArrayList;
import java.util.List;

/**
 * Created by adyachenko on 27.04.16.
 */
public class ResellerPost {
    public List<Reseller> reseller = new ArrayList<>();

    public ResellerPost() {

    }

    public ResellerPost(List<Reseller> reseller) {
        setResellerPost(reseller);
    }

    public ResellerPost setResellerPost(List<Reseller> reseller) {
        this.reseller.addAll(reseller);
        return this;
    }

    public ResellerPost addResellerPost (Reseller r) {
        if(reseller == null){
            reseller = new ArrayList<>();
        }
        reseller.add(r);
        return this;
    }
}
