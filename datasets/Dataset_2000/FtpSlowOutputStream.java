public class FtpSlowOutputStream extends OutputStream
{
   private static final Log LOG = ExoLogger.getLogger("exo.jcr.framework.command.FtpSlowOutputStream");
   private OutputStream nativeOutputStream;
   private int bytesPerSec;
   private int blockSize;
   private int writed = 0;
   public FtpSlowOutputStream(OutputStream nativeOutputStream, int bytesPerSec)
   {
      this.nativeOutputStream = nativeOutputStream;
      this.bytesPerSec = bytesPerSec;
      blockSize = bytesPerSec / 10;
   }
   protected void tryWaiting()
   {
      if (writed >= blockSize)
      {
         try
         {
            Thread.sleep(100);
         }
         catch (Exception exc)
         {
            LOG.info("Unhandled exception. " + exc.getMessage(), exc);
         }
         writed = 0;
      }
   }
   public void write(int dataByte) throws IOException
   {
      tryWaiting();
      nativeOutputStream.write(dataByte);
      writed++;
   }
   public void write(byte[] dataBytes) throws IOException
   {
      write(dataBytes, 0, dataBytes.length);
   }
   public void write(byte[] dataBytes, int offset, int len) throws IOException
   {
      int allWrited = 0;
      int curOffset = offset;
      while (allWrited < len)
      {
         tryWaiting();
         int curBlockSize = blockSize - writed;
         if ((curBlockSize + allWrited) > len)
         {
            curBlockSize = len - allWrited;
         }
         nativeOutputStream.write(dataBytes, curOffset, curBlockSize);
         allWrited += curBlockSize;
         writed += curBlockSize;
         curOffset += curBlockSize;
      }
   }
   public void flush() throws IOException
   {
      nativeOutputStream.flush();
   }
   public void close() throws IOException
   {
      nativeOutputStream.close();
   }
}