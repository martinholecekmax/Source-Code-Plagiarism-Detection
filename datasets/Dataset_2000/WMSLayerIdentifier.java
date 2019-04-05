public class WMSLayerIdentifier extends AbstractXMLEventParser
{
    protected String identifier;
    protected String authority;
    public WMSLayerIdentifier(String namespaceURI)
    {
        super(namespaceURI);
    }
    public Object parse(XMLEventParserContext ctx, XMLEvent event, Object... args) throws XMLStreamException
    {
        String s = ctx.getStringParser().parseString(ctx, event);
        if (!WWUtil.isEmpty(s))
            this.setIdentifier(s);
        return super.parse(ctx, event, args);
    }
    @Override
    protected void doParseEventAttributes(XMLEventParserContext ctx, XMLEvent event, Object... args)
    {
        Iterator iter = event.asStartElement().getAttributes();
        if (iter == null)
            return;
        while (iter.hasNext())
        {
            Attribute attr = (Attribute) iter.next();
            if (attr.getName().getLocalPart().equals("authority") && attr.getValue() != null)
                this.setAuthority(attr.getValue());
        }
    }
    public String getIdentifier()
    {
        return identifier;
    }
    protected void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }
    public String getAuthority()
    {
        return authority;
    }
    protected void setAuthority(String authority)
    {
        this.authority = authority;
    }
}