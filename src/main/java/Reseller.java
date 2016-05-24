import java.util.Date;

/**
 * Created by adyachenko on 25.04.16.
 */
public class Reseller {
//    public Integer id;
    public String first_name;
    public String last_name;
    public String email;
    public String login;
//    public String slug;
//    public Date created_at;
//    public Date updated_at;

    public Reseller() {

    }

        public Reseller(Integer id, String first_name, String last_name, String email, String login, String slug, Date created_at, Date updated_at) {
//        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.login = login;
//        this.slug = slug;
//        this.created_at = created_at;
//        this.updated_at = updated_at;
    }
    public Reseller(String first_name, String last_name, String email, String login) {
//        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.login = login;
}

}
