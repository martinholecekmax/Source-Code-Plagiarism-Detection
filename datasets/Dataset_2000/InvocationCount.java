public class InvocationCount {
  private static final Logger s_logger = LoggerFactory.getLogger(InvocationCount.class);
  private static final long REPORT = 1000000000L;
  private final String _name;
  private final AtomicLong _calls = new AtomicLong();
  private final AtomicLong _time = new AtomicLong();
  private long _lastReport = System.nanoTime();
  public InvocationCount(final String name) {
    _name = name;
  }
  
  public void enter() {
    _time.addAndGet(-System.nanoTime());
  }
  
  public long leave() {
    final long calls = _calls.incrementAndGet();
    final long now = System.nanoTime();
    long time = _time.addAndGet(now);
    if (now - _lastReport > REPORT) {
      synchronized (this) {
        if (now - _lastReport > REPORT) {
          _lastReport = now;
          while (time < 0) {
            Thread.yield();
            time = _time.get();
          }
          s_logger.debug("{} calls to {} in {}ms", new Object[] {calls, _name, (double) time / 1e6 });
        }
      }
    }
    return calls;
  }
}