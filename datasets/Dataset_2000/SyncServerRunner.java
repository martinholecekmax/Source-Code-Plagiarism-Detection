public class SyncServerRunner implements Callable<Object> {
  private SyncServer syncServer;
    SyncServerRunner(Configuration conf) {
    try {
      syncServer = SyncServiceFactory.getSyncServer(conf);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  public Configuration init(Configuration conf) throws Exception {
    return syncServer.init(conf);
  }
  public void stop() {
    syncServer.stopServer();
  }
  @Override
  public Object call() throws Exception {
    syncServer.start();
    return null;
  }
  @Override
  protected void finalize() throws Throwable {
    syncServer.stopServer();
  }
}