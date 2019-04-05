public class ContentTestDataConfigHolder
{
    private ContentTypeConfig config;
    private Document standardConfigDoc;
    public ContentTypeConfig getConfig()
    {
        return config;
    }
    public void setConfig( ContentTypeConfig config )
    {
        this.config = config;
    }
    public Element getStandardConfigElement()
    {
        return standardConfigDoc.getRootElement();
    }
    public Document getStandardConfigDoc()
    {
        return standardConfigDoc;
    }
    public void setStandardConfigDoc( Document standardConfigDoc )
    {
        this.standardConfigDoc = standardConfigDoc;
    }
    public DataEntryConfig getInputConfig( String inputName )
    {
        return config.getInputConfig( inputName );
    }
}