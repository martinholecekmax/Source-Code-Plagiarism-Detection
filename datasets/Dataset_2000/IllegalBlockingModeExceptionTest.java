public class IllegalBlockingModeExceptionTest extends TestCase {
    
    public void test_Constructor() {
        IllegalBlockingModeException e = new IllegalBlockingModeException();
        assertNull(e.getMessage());
        assertNull(e.getLocalizedMessage());
        assertNull(e.getCause());
    }
    
    public void testSerializationSelf() throws Exception {
        SerializationTest.verifySelf(new IllegalBlockingModeException());
    }
    
    public void testSerializationCompatibility() throws Exception {
        SerializationTest
                .verifyGolden(this, new IllegalBlockingModeException());
    }
}