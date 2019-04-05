public class MediaCopyright extends ElementWrapper {
    public MediaCopyright(Element internal) {
        super(internal);
    }
    public MediaCopyright(Factory factory) {
        super(factory, MediaConstants.COPYRIGHT);
    }
    public IRI getUrl() {
        String url = getAttributeValue("url");
        return (url != null) ? new IRI(url) : null;
    }
    public void setUrl(String url) {
        if (url != null)
            setAttributeValue("url", (new IRI(url)).toString());
        else
            removeAttribute(new QName("url"));
    }
}