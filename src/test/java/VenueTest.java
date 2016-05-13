import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

public class VenueTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Venue_instantiatesCorrectly_true() {
    Venue myVenue = new Venue("Venue1");
    assertEquals(true, myVenue instanceof Venue);
  }

  @Test
  public void getName_venueInstantiatesWithName_String() {
    Venue myVenue = new Venue("Venue1");
    assertEquals("Venue1", myVenue.getName());
  }

  @Test
  public void all_emptyAtFirst_0() {
    assertEquals(0, Venue.all().size());
  }



}
