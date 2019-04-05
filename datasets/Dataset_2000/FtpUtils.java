public class FtpUtils
{
   protected static Log log = ExoLogger.getLogger("exo.jcr.framework.command.FtpUtils");
   public static int getReplyCode(String reply)
   {
      if (reply.charAt(3) != ' ')
      {
         return -1;
      }
      String replyCodeVal = reply.substring(0, 3);
      return new Integer(replyCodeVal);
   }
   public static boolean isPortFree(int port)
   {
      try
      {
         ServerSocket serverSocket = new ServerSocket(port);
         serverSocket.close();
         return true;
      }
      catch (Exception exc)
      {
         log.info(FtpConst.EXC_MSG + exc.getMessage(), exc);
      }
      return false;
   }
}