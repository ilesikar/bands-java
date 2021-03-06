import org.sql2o.*;
import org.junit.*;
import java.util.List;
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

  @Test
  public void save_savesObjectIntoDatabase_true() {
    Band myBand = new Band("BandName");
    myBand.save();
    assertTrue(Band.all().get(0).equals(myBand));
  }

  @Test
  public void save_assignsIdToObject_int() {
    Band myBand = new Band("BandName");
    myBand.save();
    Band savedBand = Band.all().get(0);
    assertEquals(myBand.getId(), savedBand.getId());
  }

  @Test
  public void find_findsBandInDatabase_true() {
    Band myBand = new Band("BandName");
    myBand.save();
    Band savedBand = Band.find(myBand.getId());
    assertTrue(myBand.equals(savedBand));
  }

  @Test
  public void update_updatesBandName_true() {
    Band myBand = new Band("Band1");
    myBand.save();
    myBand.update("Band2");
    assertEquals("Band2", Band.find(myBand.getId()).getName());
  }

  @Test
  public void delete_deletesBand_true() {
    Band myBand = new Band("Band1");
    myBand.save();
    int myBandId = myBand.getId();
    myBand.delete();
    assertEquals(null, Band.find(myBandId));
  }

  @Test
  public void addVenue_addsVenueToBand() {
    Venue myVenue = new Venue("Venue1");
    myVenue.save();
    Band myBand = new Band("Band1");
    myBand.save();
    myBand.addVenue(myVenue);
    Venue savedVenue = myBand.getVenues().get(0);
    assertTrue(myVenue.equals(savedVenue));
  }

  @Test
  public void getVenues_returnsAllVenues_List() {
    Venue myVenue = new Venue("Venue1");
    myVenue.save();
    Band myBand = new Band("Band1");
    myBand.save();
    myBand.addVenue(myVenue);
    List savedVenues = myBand.getVenues();
    assertEquals(1, savedVenues.size());
  }

  @Test
  public void delete_deletesAllBandAndVenueAssociations() {
    Venue myVenue = new Venue("Venue1");
    myVenue.save();
    Band myBand = new Band("Band1");
    myBand.save();
    myBand.addVenue(myVenue);
    myBand.delete();
    assertEquals(0, myBand.getVenues().size());
  }


}
