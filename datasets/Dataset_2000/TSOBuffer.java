public class TSOBuffer {
   private static final Log LOG = LogFactory.getLog(TSOBuffer.class);
   private static final int CAPACITY = 1024*1024;
   public ChannelBuffer buffer;
   public TreeSet<TSOSharedMessageBuffer.ReadingBuffer> readingBuffers = new TreeSet<TSOSharedMessageBuffer.ReadingBuffer>();
   private int pendingWrites = 0;
   public static long nBuffers;
   public TSOBuffer() {
      this(true);
   }
   public TSOBuffer(boolean allocateBuffer) {
      nBuffers++;
      LOG.warn("Allocated buffer");
      if (allocateBuffer)
         buffer = ChannelBuffers.directBuffer(CAPACITY);
   }
   public TSOBuffer reading(TSOSharedMessageBuffer.ReadingBuffer buf) {
      readingBuffers.add(buf);
      return this;
   }
   public synchronized void incrementPending() {
      ++pendingWrites;
   }
   public synchronized boolean decrementPending() {
      return --pendingWrites == 0;
   }
}