import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by adyachenko on 25.04.16.
 */
public class TestReseller {
    @Test
    public void TestLogins() throws IOException, JSONException {
        ArrayList logins = new ArrayList<>();
        ArrayList elements = new ArrayList<>();
        logins.add("chewbacca");
        logins.add("chew");
//        elements = Requester.parseJsonArray(Requester.get(Connection.HttpConnection("http://api.cwatch.com/resellers")), ResellerConst.OBJECT_NAME, ResellerConst.LOGIN);
        Assert.assertEquals(elements, logins);
    }
}
