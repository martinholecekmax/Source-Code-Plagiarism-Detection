public class KeySelectorExceptionTest extends org.junit.Assert {
    @org.junit.Test
    public void testConstructor() {
                KeySelectorException kse = new KeySelectorException();
        assertNull(kse.getMessage());
        assertNull(kse.getCause());
                kse = new KeySelectorException("test");
        assertEquals("test", kse.getMessage());
        assertNull(kse.getCause());
                IllegalArgumentException iae = new IllegalArgumentException("iae");
        kse = new KeySelectorException("random", iae);
        assertEquals("random", kse.getMessage());
        assertTrue(compareThrowable(iae, kse.getCause()));
                kse = new KeySelectorException(iae);
        assertEquals(iae.toString(), kse.getMessage());
        assertTrue(compareThrowable(iae, kse.getCause()));
    }
    private static boolean compareThrowable(Throwable t1, Throwable t2) {
        boolean result = false;
                if (t1.toString().equals(t2.toString())) {
            ByteArrayOutputStream baos1 = new ByteArrayOutputStream();
            ByteArrayOutputStream baos2 = new ByteArrayOutputStream();
                        PrintStream ps = new PrintStream(baos1);
            t1.printStackTrace(ps);
            ps.close();
            ps = new PrintStream(baos2);
            t2.printStackTrace(ps);
            ps.close();
            if (Arrays.equals(baos1.toByteArray(), baos2.toByteArray())) {
                result = true;
            } else {
                System.out.println("StackTrace comparison failed");
                t1.printStackTrace(System.out);
                t2.printStackTrace(System.out);
            }
        } else {
            System.out.println("ToString comparison failed");
            System.out.println(t1);
            System.out.println(t2);
        }
        return result;
    }
}