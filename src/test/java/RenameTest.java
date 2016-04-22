import org.junit.*;
import static org.junit.Assert.*;

public class ClassnameTest {

  @Test
  public void DescriptiveTestName_Replace() {
    Classname newClassname = new Classname();
    assertEquals(true, newClassname.answer("top", "pot"));
  }
}
