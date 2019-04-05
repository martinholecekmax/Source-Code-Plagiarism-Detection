public class HtmlUListBuilderTest extends ElementBuilderTestBase<UListBuilder> {
  @Override
  protected UListBuilder createElementBuilder(ElementBuilderFactory factory) {
    return factory.createUListBuilder();
  }
  @Override
  protected void endElement(ElementBuilderBase<?> builder) {
    builder.endUList();
  }
  @Override
  protected UListBuilder startElement(ElementBuilderBase<?> builder) {
    return builder.startUList();
  }
}