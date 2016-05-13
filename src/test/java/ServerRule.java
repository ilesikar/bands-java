import org.junit.rules.ExternalResource;
import spark.Spark;

public class ServerRule extends ExternalResource {

  protected void before() {
    String[] args = {};
    App.main(args); //Change App to w/e main class is
  }

  protected void after() {
    Spark.stop();
  }
}
