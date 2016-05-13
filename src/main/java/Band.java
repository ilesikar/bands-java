import java.util.List;
import org.sql2o.*;

public class Band {
  private int id;
  private String name;

  public Band(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public static List<Band> all() {
  String sql = "SELECT id, name FROM bands";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Band.class);
  }
}

}
