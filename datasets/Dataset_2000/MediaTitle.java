public class MediaTitle extends ElementWrapper {
    public MediaTitle(Element internal) {
        super(internal);
    }
    public MediaTitle(Factory factory) {
        super(factory, MediaConstants.TITLE);
    }
    public void setType(MediaConstants.Type type) {
        switch (type) {
            case PLAIN:
                setAttributeValue("type", "plain");
                break;
            case HTML:
                setAttributeValue("type", "html");
                break;
            default:
                removeAttribute(new QName("type"));
        }
    }
    public MediaConstants.Type getType() {
        String type = getAttributeValue("type");
        return (type != null) ? MediaConstants.Type.valueOf(type.toUpperCase()) : null;
    }
}