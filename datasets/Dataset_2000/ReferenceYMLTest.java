public class ReferenceYMLTest extends UnitTest {
    @Before
    public void setup() {
    	Logger.info("Deleting data...");
    	MorphiaFixtures.delete(Child.class, Parent.class);
    	Logger.info("Inserting data...");
    	MorphiaFixtures.loadModels("initial-data.yml");
    }
    @Test
    public void testSimpleReference() {
       Parent parent = Parent.find("byParentName","parent").first();
       Assert.assertNotNull("Parent not found!", parent);
       Assert.assertNotNull("Child is null, reference didn't load correctly",parent.child);
    }
}