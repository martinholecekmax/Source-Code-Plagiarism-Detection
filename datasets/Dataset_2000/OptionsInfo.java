public class OptionsInfo implements XmlSerializable {
    private static Logger log = LoggerFactory.getLogger(OptionsInfo.class);
    private final Set<String> entriesLocalNames = new HashSet<String>();
    
    public OptionsInfo(String[] entriesLocalNames) {
       if (entriesLocalNames != null) {
           this.entriesLocalNames.addAll(Arrays.asList(entriesLocalNames));
       }
    }
    
    private OptionsInfo() {}
    
    public boolean containsElement(String localName, Namespace namespace) {
        if (DeltaVConstants.NAMESPACE.equals(namespace)) {
            return entriesLocalNames.contains(localName);
        }
        return false;
    }
    
    public Element toXml(Document document) {
        Element optionsElem = DomUtil.createElement(document, DeltaVConstants.XML_OPTIONS, DeltaVConstants.NAMESPACE);
        for (String localName : entriesLocalNames) {
            DomUtil.addChildElement(optionsElem, localName, DeltaVConstants.NAMESPACE);
        }
        return optionsElem;
    }
    
    public static OptionsInfo createFromXml(Element optionsElement) throws DavException {
        if (!DomUtil.matches(optionsElement, DeltaVConstants.XML_OPTIONS, DeltaVConstants.NAMESPACE)) {
            log.warn("DAV:options element expected");
            throw new DavException(DavServletResponse.SC_BAD_REQUEST);
        }
        OptionsInfo oInfo = new OptionsInfo();
        ElementIterator it = DomUtil.getChildren(optionsElement);
        while (it.hasNext()) {
                        oInfo.entriesLocalNames.add(it.nextElement().getLocalName());
        }
        return oInfo;
    }
}