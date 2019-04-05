public abstract class AbstractNamedWriter extends AbstractWriter implements NamedWriter {
    protected final String name;
    protected final String[] formats;
    protected AbstractNamedWriter(String name, String... formats) {
        this.name = name;
        this.formats = formats;
    }
    public String getName() {
        return name;
    }
    public String[] getOutputFormats() {
        return formats;
    }
    public boolean outputsFormat(String mediatype) {
        for (String format : formats) {
            if (MimeTypeHelper.isMatch(format, mediatype))
                return true;
        }
        return false;
    }
}