import java.util.List;
import org.sql2o.*;

public class Venue {
  private int id;
  private String name;

  public Venue(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public static List<Venue> all() {
    String sql = "SELECT id, name FROM venues";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Venue.class);
    }
  }

}
