public class CLCTest extends TestCase {
  ControlLoggerContext clc;
  protected void setUp() throws Exception {
    clc = new ControlLoggerContext();
  }
  public void test1() {
    ControlLogger x = clc.getLogger("x");
    assertEquals("x", x.getName());
    assertEquals(clc.getRootLogger(), x.parent);
    ControlLogger abc = clc.getLogger("a.b.c");
    assertEquals("a.b.c", abc.getName());
    assertEquals(Level.DEBUG, abc.getEffectiveLevel());
  }
  public void testCreation() {
    ControlLogger xyz = clc.getLogger("x.y.z");
    assertEquals("x.y.z", xyz.getName());
    assertEquals("x.y", xyz.parent.getName());
    assertEquals("x", xyz.parent.parent.getName());
    assertEquals("root", xyz.parent.parent.parent.getName());
    ControlLogger xyz_ = clc.exists("x.y.z");
    assertEquals("x.y.z", xyz_.getName());
  }
}