@XmlAccessorType(XmlAccessType.PROPERTY)
public class KlocworkOutputMetric extends AbstractOutputMetric implements Serializable {
    private static final long serialVersionUID = 1L;
    @Override
    @XmlElement
    public String getDescription() {
        return "klocwork";
    }
    @Override
    @XmlElement
    public String getKey() {
        return "KLOCWORK OUTPUT FORMAT 9.2";
    }
    @Override
    @XmlElement
    public String getVersion() {
        return "9.2";
    }
    @Override
    @XmlElement
    public String[] getXsdNameList() {
        return new String[]{"xsd/klocwork-9.2.xsd"};
    }
}