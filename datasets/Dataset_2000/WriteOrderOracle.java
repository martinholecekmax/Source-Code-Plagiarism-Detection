public final class WriteOrderOracle {
  private WriteOrderOracle() {}
  private static final AtomicLong WRITER_ORDERER =
      new AtomicLong(System.currentTimeMillis());
  public static void setSeed(long highest) {
    long previous;
    while(highest > (previous = WRITER_ORDERER.get())) {
      WRITER_ORDERER.compareAndSet(previous, highest);
    }
  }
  public static long next() {
    return WRITER_ORDERER.incrementAndGet();
  }
}