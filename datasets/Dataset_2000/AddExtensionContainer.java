@ComponentConfig(
  template = "app:/templates/wiki/webui/control/AddExtensionContainer.gtmpl"
)
public class AddExtensionContainer extends UIWikiExtensionContainer {
  public static final String EXTENSION_TYPE = "org.exoplatform.wiki.webui.control.AddExtensionContainer";
  private static final List<UIExtensionFilter> FILTERS = Arrays.asList(new UIExtensionFilter[] {});
  @UIExtensionFilters
  public List<UIExtensionFilter> getFilters() {
    return FILTERS;
  }
  @Override
  public String getExtensionType() {
    return EXTENSION_TYPE;
  }
}