public class TrackManagerHandler extends DefaultHandler
{
    private ObjectStoreWriter osw;
    private DefaultHandler trackHandler = null;
    
    public TrackManagerHandler(ObjectStoreWriter uosw) {
        super();
        this.osw = uosw;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs)
        throws SAXException {
        if (TemplateTrackBinding.TEMPLATETRACKS.equals(qName)) {
            trackHandler = new TemplateTrackHandler(osw);
        } else if (LoginTrackBinding.LOGINTRACKS.equals(qName)) {
            trackHandler = new LoginTrackHandler(osw);
        } else if (ListTrackBinding.LISTTRACKS.equals(qName)) {
            trackHandler = new ListTrackHandler(osw);
        } else if (QueryTrackBinding.QUERYTRACKS.equals(qName)) {
            trackHandler = new QueryTrackHandler(osw);
        } else if (SearchTrackBinding.SEARCHTRACKS.equals(qName)) {
            trackHandler = new SearchTrackHandler(osw);
        }
        if (trackHandler != null) {
            trackHandler.startElement(uri, localName, qName, attrs);
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (TemplateTrackBinding.TEMPLATETRACKS.equals(qName)
            || LoginTrackBinding.LOGINTRACKS.equals(qName)
            || ListTrackBinding.LISTTRACKS.equals(qName)
            || QueryTrackBinding.QUERYTRACKS.equals(qName)
            || SearchTrackBinding.SEARCHTRACKS.equals(qName)) {
            trackHandler.endElement(uri, localName, qName);
            trackHandler = null;
        }
    }
}