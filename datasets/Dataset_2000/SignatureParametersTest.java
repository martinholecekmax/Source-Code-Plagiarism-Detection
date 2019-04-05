public class SignatureParametersTest {
    @Test
    public void testLoadSave() throws IOException {
        for (SignatureParameters params: new SignatureParameters[] {SignatureParameters.TEST157, SignatureParameters.TEST157_PROD})
            testLoadSave(params);
    }
    private void testLoadSave(SignatureParameters params) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        params.writeTo(os);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        assertEquals(params, new SignatureParameters(is));
    }
    @Test
    public void testEqualsHashCode() throws IOException {
        for (SignatureParameters params: new SignatureParameters[] {SignatureParameters.TEST157, SignatureParameters.TEST157_PROD})
            testEqualsHashCode(params);
    }
    private void testEqualsHashCode(SignatureParameters params) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        params.writeTo(os);
        ByteArrayInputStream is = new ByteArrayInputStream(os.toByteArray());
        SignatureParameters params2 = new SignatureParameters(is);
        assertEquals(params, params2);
        assertEquals(params.hashCode(), params2.hashCode());
        params.N += 1;
        assertFalse(params.equals(params2));
        assertFalse(params.equals(params2));
        assertFalse(params.hashCode() == params2.hashCode());
    }
    @Test
    public void testClone() {
        for (SignatureParameters params: new SignatureParameters[] {SignatureParameters.TEST157, SignatureParameters.TEST157_PROD})
            assertEquals(params, params.clone());
    }
}