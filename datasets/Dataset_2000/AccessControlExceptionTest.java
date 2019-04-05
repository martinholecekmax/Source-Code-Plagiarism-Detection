public class AccessControlExceptionTest extends SerializationTest implements
        SerializationTest.SerializableAssert {
    protected Object[] getData() {
        AllPermission allperms = new AllPermission();
        return new Object[] { new AccessControlException(null),
                new AccessControlException("string1"),
                new AccessControlException(null, null),
                new AccessControlException("string2", allperms) };
    }
    public void assertDeserialized(Serializable oref, Serializable otest) {
                THROWABLE_COMPARATOR.assertDeserialized(oref, otest);
                AccessControlException ref = (AccessControlException) oref;
        AccessControlException test = (AccessControlException) otest;
        Permission p = ref.getPermission();
        if (p == null) {
            assertNull(test.getPermission());
        } else {
            assertEquals(p, test.getPermission());
        }
    }
}