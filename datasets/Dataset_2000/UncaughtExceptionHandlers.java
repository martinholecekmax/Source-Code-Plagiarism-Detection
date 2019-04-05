public final class UncaughtExceptionHandlers {
  private UncaughtExceptionHandlers() {}
  
  public static UncaughtExceptionHandler systemExit() {
    return new Exiter(Runtime.getRuntime());
  }
  @VisibleForTesting static final class Exiter implements UncaughtExceptionHandler {
    private static final Logger logger = Logger.getLogger(Exiter.class.getName());
    private final Runtime runtime;
    Exiter(Runtime runtime) {
      this.runtime = runtime;
    }
    @Override public void uncaughtException(Thread t, Throwable e) {
            logger.log(SEVERE, String.format("Caught an exception in %s.  Shutting down.", t), e);
      runtime.exit(1);
    }
  }
}