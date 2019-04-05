public class CompactObjectSerializationTest {
    @Test
    public void testInterfaceSerialization() throws Exception {
        PipedOutputStream pipeOut = new PipedOutputStream();
        PipedInputStream pipeIn = new PipedInputStream(pipeOut);
        CompactObjectOutputStream out = new CompactObjectOutputStream(pipeOut);
        CompactObjectInputStream in = new CompactObjectInputStream(pipeIn, ClassResolvers.cacheDisabled(null));
        out.writeObject(List.class);
        Assert.assertSame(List.class, in.readObject());
    }
}