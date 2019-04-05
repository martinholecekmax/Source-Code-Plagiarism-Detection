public class HTMLPanelParser implements ElementParser {
  public void parse(XMLElement elem, String fieldName, JClassType type,
      final UiBinderWriter writer) throws UnableToCompleteException {
    
    WidgetInterpreter widgetInterpreter = new WidgetInterpreter(fieldName,
        writer);
    
    HtmlInterpreter htmlInterpreter = makeHtmlInterpreter(fieldName, writer);
    writer.beginAttachedSection(fieldName + ".getElement()");
    String html = elem.consumeInnerHtml(InterpreterPipe.newPipe(
        widgetInterpreter, htmlInterpreter));
    writer.endAttachedSection();
    
    String customTag = elem.consumeStringAttribute("tag", null);
    if (null == customTag) {
      writer.setFieldInitializerAsConstructor(fieldName, type, "\"" + html
          + "\"");
    } else {
      writer.setFieldInitializerAsConstructor(fieldName, type, customTag, "\""
          + html + "\"");
    }
  }
  
  private HtmlInterpreter makeHtmlInterpreter(final String fieldName,
      final UiBinderWriter uiWriter) {
    final String ancestorExpression = fieldName + ".getElement()";
    PlaceholderInterpreterProvider placeholderInterpreterProvider = new PlaceholderInterpreterProvider() {
      public PlaceholderInterpreter get(MessageWriter message) {
        return new WidgetPlaceholderInterpreter(fieldName, uiWriter, message,
            ancestorExpression);
      }
    };
    HtmlInterpreter htmlInterpreter = new HtmlInterpreter(uiWriter,
        ancestorExpression, new HtmlMessageInterpreter(uiWriter,
            placeholderInterpreterProvider));
    return htmlInterpreter;
  }
}