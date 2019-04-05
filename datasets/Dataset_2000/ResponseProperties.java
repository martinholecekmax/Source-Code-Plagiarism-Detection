public class ResponseProperties
{
   
   private MultiValuedPropertyMap<String> transportHeaders = new SimpleMultiValuedPropertyMap<String>();
   
   private MultiValuedPropertyMap<Element> markupHeaders = new SimpleMultiValuedPropertyMap<Element>();
   
   private List<Cookie> cookies = new LinkedList<Cookie>();
   public ResponseProperties()
   {
   }
   public MultiValuedPropertyMap<String> getTransportHeaders()
   {
      return transportHeaders;
   }
   public MultiValuedPropertyMap<Element> getMarkupHeaders()
   {
      return markupHeaders;
   }
   public List<Cookie> getCookies()
   {
      return cookies;
   }
   public void append(ResponseProperties appended)
   {
      if (appended == null)
      {
         throw new IllegalArgumentException();
      }
            transportHeaders.append(appended.transportHeaders);
      markupHeaders.append(appended.markupHeaders);
      cookies.addAll(appended.cookies);
   }
   public void clear()
   {
      transportHeaders.clear();
      markupHeaders.clear();
      cookies.clear();
   }
}