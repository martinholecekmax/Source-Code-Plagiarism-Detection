public class AsyncExecute {
  static Logger log = Logger.getLogger(AsyncExecute.class.getName());
  
  public static void sleepTightInSeconds(long timeoutInSeconds) {
    sleepTight(timeoutInSeconds * 1000);
  }
  
  public static void sleepTight(long timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
  
  public static int killProcess(Process process) {
    process.destroy();
    int exitValue;
    try {
      exitValue = ProcessUtils.waitForProcessDeath(process, 10000);
      ProcessUtils.closeAllStreamsAndDestroyProcess( process);
    } catch (ProcessUtils.ProcessStillAliveException ex) {
      if (WindowsUtils.thisIsWindows()) {
        throw ex;
      }
      try {
        log.info("Process didn't die after 10 seconds");
        UnixUtils.kill9(process);
        exitValue = ProcessUtils.waitForProcessDeath(process, 10000);
        ProcessUtils.closeAllStreamsAndDestroyProcess( process);
      } catch (Exception e) {
        log.log(Level.SEVERE, "Process refused to die after 10 seconds, and couldn't kill9 it", e);
        throw new RuntimeException(
            "Process refused to die after 10 seconds, and couldn't kill9 it: " + e.getMessage(),
            ex);
      }
    }
    return exitValue;
  }
}