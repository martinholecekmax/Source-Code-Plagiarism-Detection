public interface OMMonitor extends OMMonitorProgress
{
  
  public static final int THOUSAND = 1000;
  
  public static final double DEFAULT_TIME_FACTOR = THOUSAND;
  
  public boolean isCanceled();
  
  public void checkCanceled() throws MonitorCanceledException;
  
  public boolean hasBegun() throws MonitorCanceledException;
  
  public OMMonitor begin(double totalWork) throws MonitorCanceledException;
  
  public OMMonitor begin() throws MonitorCanceledException;
  
  public void worked(double work) throws MonitorCanceledException;
  
  public void worked() throws MonitorCanceledException;
  
  public OMMonitor fork(double work);
  
  public OMMonitor fork();
  
  public Async forkAsync(double work);
  
  public Async forkAsync();
  
  public void done();
  
  public interface Async
  {
    public void stop();
  }
}