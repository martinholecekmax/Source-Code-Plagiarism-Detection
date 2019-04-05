public abstract class TextFromSingleElementHandler<V> extends ParseSax.HandlerForGeneratedRequestWithResult<V>
      implements Function<String, V> {
   private final String elementName;
   protected TextFromSingleElementHandler(String elementName) {
      this.elementName = checkNotNull(elementName, "elementName");
   }
   private StringBuilder currentText = new StringBuilder();
   private String text;
   @Override
   public V getResult() {
      return apply(text);
   }
      @Override
   public void endElement(String uri, String name, String qName) {
      if (qName.equals(elementName)) {
         text = currentOrNull(currentText);
      }
      currentText = new StringBuilder();
   }
   @Override
   public void characters(char ch[], int start, int length) {
      currentText.append(ch, start, length);
   }
}