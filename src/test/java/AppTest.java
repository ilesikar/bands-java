import org.sql2o.*;
import org.junit.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import static org.junit.Assert.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Bands and Venues");
  }

  @Test
  public void bandIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a", withText("Add A Band"));
    fill("#name").with("Band1");
    submit(".btn");
    assertThat(pageSource()).contains("Band1");
  }

  @Test
  public void bandShowPageDisplaysDescription() {
    Band testBand = new Band("Band1");
    testBand.save();
    String url = String.format("http://localhost:4567/bands/%d", testBand.getId());
    goTo(url);
    assertThat(pageSource()).contains("Band1");
  }

  @Test
    public void venueIsAddedToBand() {
      Venue testVenue = new Venue("Venue1");
      testVenue.save();
      Band testBand = new Band("Band1");
      testBand.save();
      String url = String.format("http://localhost:4567/tasks/%d", testBand.getId());
      goTo(url);
      fillSelect("#venue_id").withText("Venue1");
      submit(".btn");
      assertThat(pageSource()).contains("<li>");
      assertThat(pageSource()).contains("Venue1");
    }

}
