public class FileLockException extends IOException
{
   
   private static final long serialVersionUID = 5513012215532388738L;
   private final InterruptedException lockError;
   
   public FileLockException(String s, InterruptedException lockError)
   {
      super(s);
      this.lockError = lockError;
   }
   
   @Override
   public Throwable getCause()
   {
      return lockError;
   }
}