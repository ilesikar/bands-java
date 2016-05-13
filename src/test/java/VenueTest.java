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

  @Test
  public void equals_returnsTrueIfNamesAretheSame_true() {
    Venue firstVenue = new Venue("Venue1");
    Venue secondVenue = new Venue("Venue1");
    assertTrue(firstVenue.equals(secondVenue));
  }

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Venue myVenue = new Venue("Venue1");
    myVenue.save();
    assertTrue(Venue.all().get(0).equals(myVenue));
  }



}
