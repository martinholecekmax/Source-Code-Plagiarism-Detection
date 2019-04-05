public class MockInitialContextFactory implements InitialContextFactory {
  private static final Map<String, Object> objects = new HashMap<String, Object>();
  private final IMocksControl mockControl;
  private final javax.naming.Context context;
  public MockInitialContextFactory() {
    mockControl = EasyMock.createStrictControl();
    context = mockControl.createMock(javax.naming.Context.class);
    try {
      EasyMock.expect(context.lookup((String) EasyMock.anyObject())).andAnswer(
          new IAnswer<Object>() {
            public Object answer() throws Throwable {
              return objects.get(EasyMock.getCurrentArguments()[0]);
            }
          }).anyTimes();
    } catch (NamingException e) {
      throw new RuntimeException(e);
    }
    mockControl.replay();
  }
  @SuppressWarnings("unchecked")
  public javax.naming.Context getInitialContext(Hashtable env) {
    return context;
  }
  public static void bind(String name, Object obj) {
    objects.put(name, obj);
  }
}