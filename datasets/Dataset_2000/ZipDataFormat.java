@XmlRootElement(name = "zip")
@XmlAccessorType(XmlAccessType.FIELD)
public class ZipDataFormat extends DataFormatDefinition {
    @XmlAttribute
    private Integer compressionLevel;
    public ZipDataFormat() {
    }
    public ZipDataFormat(int compressionLevel) {
        this.compressionLevel = compressionLevel;
    }
    @Override
    protected DataFormat createDataFormat(RouteContext routeContext) {
        if (compressionLevel == null) {
            return new org.apache.camel.impl.ZipDataFormat(Deflater.DEFAULT_COMPRESSION);
        } else {
            return new org.apache.camel.impl.ZipDataFormat(compressionLevel);
        }
    }
    public Integer getCompressionLevel() {
        return compressionLevel;
    }
    public void setCompressionLevel(Integer compressionLevel) {
        this.compressionLevel = compressionLevel;
    }
}