public class NoneSensorTest extends TestCase {
  
  @Test
  public void testGetValue() {
    NoneSensor instance = new NoneSensor();
    int expResult = 0;
    int result = instance.getValue();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testUseSimulator() {
    Simulator sim = null;
    NoneSensor instance = new NoneSensor();
    instance.useSimulator(sim);
  }
  
  @Test
  public void testUseSimulatedEntity() {
    SimulatedEntity simEntity = null;
    NoneSensor instance = new NoneSensor();
    instance.useSimulatedEntity(simEntity);
  }
}