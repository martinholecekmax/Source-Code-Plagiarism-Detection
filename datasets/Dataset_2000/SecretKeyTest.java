public class SecretKeyTest extends TestCase {
    
    public SecretKeyTest(String arg0) {
        super(arg0);
    }
    
    public void testField() {
        checkSecretKey sk = new checkSecretKey();
        assertEquals("Incorrect serialVersionUID", 
                sk.getSerVerUID(),                 -4795878709595146952L);
    }
    public class checkSecretKey implements SecretKey {
        public String getAlgorithm() {
            return "SecretKey";
        }
        public String getFormat() {
            return "Format";
        }
        public byte[] getEncoded() {
            return new byte[0];
        }
        public long getSerVerUID() {
            return serialVersionUID;
        }
    }
}