public class SingleHostTrackerFactoryTest {
  private SingleHostTrackerFactory factory;
  private ServerSocket serverSocket;
  private InetSocketAddress address;
  @Before
  public void init() throws IOException {
    serverSocket = new ServerSocket(0);
    address = new InetSocketAddress(serverSocket.getInetAddress(), serverSocket.getLocalPort());
    factory = new SingleHostTrackerFactory(address, Proxy.NO_PROXY);
  }
  @After
  public void tearDown() throws IOException {
    serverSocket.close();
  }
  @Test
  public void proxy() {
    assertEquals(Proxy.NO_PROXY, factory.getProxy());
  }
  @Test
  public void getTracker() throws TrackerException {
    Tracker tracker = factory.getTracker();
    assertNotNull(tracker);
  }
  @Test
  public void getAddresses() {
    Set<InetSocketAddress> addresses = factory.getAddresses();
    assertEquals(1, addresses.size());
    InetSocketAddress actualAddress = addresses.iterator().next();
    assertEquals(address.getHostName(), actualAddress.getHostName());
    assertEquals(address.getPort(), actualAddress.getPort());
  }
}