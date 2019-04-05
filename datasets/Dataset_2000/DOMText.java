public class DOMText
        extends DOMCharacterData<Text> {
   public static DOMText __construct(Env env, @Optional String value) {
      DOMText text = getImpl(env).createText();
      if (value != null && value.length() > 0) {
         text.setNodeValue(value);
      }
      return text;
   }
   DOMText(DOMImplementation impl, Text delegate) {
      super(impl, delegate);
   }
   public String getWholeText() {
      return _delegate.getWholeText();
   }
   public boolean isElementContentWhitespace() {
      return _delegate.isElementContentWhitespace();
   }
   public boolean isWhitespaceInElementContent() {
      return _delegate.isElementContentWhitespace();
   }
   public DOMText replaceWholeText(String content)
           throws DOMException {
      try {
         return wrap(_delegate.replaceWholeText(content));
      } catch (org.w3c.dom.DOMException ex) {
         throw wrap(ex);
      }
   }
   public DOMText splitText(int offset)
           throws DOMException {
      try {
         return wrap(_delegate.splitText(offset));
      } catch (org.w3c.dom.DOMException ex) {
         throw wrap(ex);
      }
   }
}