public class KeystoreUtilUnitTestCase extends TestCase {
    
    private String keystoreLocation = "keystore/jbid_test_keystore.jks";
    private String keystorePass = "store123";
    private String alias = "servercert";
    private String keyPass = "test123";
    
    public void testSignatureValidationInvalidation() throws Exception {
        ClassLoader tcl = Thread.currentThread().getContextClassLoader();
        InputStream ksStream = tcl.getResourceAsStream(keystoreLocation);
        assertNotNull("Input keystore stream is not null", ksStream);
        KeyStore ks = KeyStoreUtil.getKeyStore(ksStream, keystorePass.toCharArray());
        assertNotNull("KeyStore is not null", ks);
                Enumeration<String> aliases = ks.aliases();
        assertTrue("Aliases are not empty", aliases.hasMoreElements());
        PublicKey publicKey = KeyStoreUtil.getPublicKey(ks, alias, keyPass.toCharArray());
        assertNotNull("Public Key is not null", publicKey);
        PrivateKey privateKey = (PrivateKey) ks.getKey(alias, keyPass.toCharArray());
        String content = "Hello";
        byte[] sigValue = SignatureUtil.sign(content, privateKey);
        boolean isValid = SignatureUtil.validate(content.getBytes("UTF-8"), sigValue, publicKey);
        assertTrue("Valid sig?", isValid);
    }
}