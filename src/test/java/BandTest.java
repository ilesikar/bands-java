import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly_true() {
    Band myBand = new Band("BandName");
    assertEquals(true, myBand instanceof Band);
  }

  @Test
  public void getName_bandInstantiatesWithName_String() {
    Band myBand = new Band("BandName");
    assertEquals("BandName", myBand.getName());
  }

  @Test public void all_emptyAtFirst_0() {
    assertEquals(0, Band.all().size());
  }

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Band firstBand = new Band("BandName");
    Band secondBand = new Band("BandName");
    assertTrue(firstBand.equals(secondBand));
  }

}
