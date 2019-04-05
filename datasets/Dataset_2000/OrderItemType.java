@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="Item", propOrder={
    "description",
    "name"
}, namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonAggregateComponents-2")
public class OrderItemType {
    @XmlElement(name="Description",
        namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    private String description;
    @XmlElement(name="Name",
        namespace="urn:oasis:names:specification:ubl:schema:xsd:CommonBasicComponents-2")
    private String name;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}