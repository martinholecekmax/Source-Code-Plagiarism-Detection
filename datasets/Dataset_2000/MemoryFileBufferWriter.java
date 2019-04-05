public class MemoryFileBufferWriter{
  public final static String PRM_SESSION_BUFFER = "smb";
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
  {
    try
    {
      String sessionName = request.getParameter(PRM_SESSION_BUFFER);
      if(sessionName !=null){
        if(request.getSession().getAttribute(sessionName)!=null){
          MemoryFileBuffer mfb = (MemoryFileBuffer) request.getSession().getAttribute(sessionName);
          request.getSession().removeAttribute(sessionName);
          MemoryInputStream mis = new MemoryInputStream(mfb);
          ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    while (mis.available() > 0)
          {
            baos.write(mis.read());
          }
          response.setContentType(mfb.getMimeType());
          response.setContentLength(baos.size());
          ServletOutputStream out = response.getOutputStream();
          baos.writeTo(out);
          out.flush();
          mis.close();
          baos.close();
        }
      }
    }
    catch (Exception e2){
      e2.printStackTrace();
      System.out.println("Error in "+getClass().getName()+"\n"+e2);
    }
  }
}