public class MagentoClientAdaptorUnitTest
{
    private static final String MESSAGE = "Ups!";
    private FooBar handled = MagentoClientAdaptor.adapt(FooBar.class, new FooBarImp());
    @Test
    public void testHandleException() throws Exception
    {
        try
        {
            handled.bar();
            fail();
        }
        catch (MagentoException e)
        {
            assertEquals(101, e.getFaultCode());
            assertEquals(MESSAGE, e.getMessage());
            assertThat(e.getCause(), instanceOf(AxisFault.class));
        }
    }
    @Test
    public void testJustDelegate() throws Exception
    {
        assertEquals("foo", handled.foo());
    }
    public static interface FooBar
    {
        String foo() throws RemoteException;
        String bar() throws RemoteException;
    }
    public static class FooBarImp implements FooBar
    {
        public String foo() throws RemoteException
        {
            return "foo";
        }
        public String bar() throws RemoteException
        {
            throw new AxisFault(QName.valueOf("101"), MESSAGE, "The actor", new Element[]{});
        }
        public Class<?> getClientType()
        {
            return FooBar.class;
        }
    }
}