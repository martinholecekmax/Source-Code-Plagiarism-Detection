public class StylesheetRenderer extends Renderer
{
  public boolean supportsComponentType(UIComponent component)
  {
    return (component instanceof UIOutput);
  }
  public void decode(FacesContext context, UIComponent component)
  {
  }
  public void encodeBegin(FacesContext context, UIComponent component)
    throws IOException
  {
    ;
  }
  public void encodeChildren(FacesContext context, UIComponent component)
    throws IOException
  {
    ;
  }
  
  public void encodeEnd(FacesContext context, UIComponent component)
    throws IOException
  {
    if ( (context == null) || (component == null))
    {
      throw new NullPointerException();
    }
    ResponseWriter writer = context.getResponseWriter();
    String contextPath = context.getExternalContext()
      .getRequestContextPath();
    writer.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"");
    writer.write(contextPath);
    writer.write( (String) component.getAttributes().get("path"));
    writer.write("\"/>");
  }
}