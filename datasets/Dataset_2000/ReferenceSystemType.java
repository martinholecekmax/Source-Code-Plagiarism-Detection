@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReferenceSystemType", propOrder = {
    "namedReferenceSystem"
})
public class ReferenceSystemType {
    @XmlElementRef(name = "_NamedReferenceSystem", namespace = "http:    private List<JAXBElement<? extends AbstractNamedReferenceSystem>> namedReferenceSystem;
    
    public List<JAXBElement<? extends AbstractNamedReferenceSystem>> getNamedReferenceSystem() {
        if (namedReferenceSystem == null) {
            namedReferenceSystem = new ArrayList<JAXBElement<? extends AbstractNamedReferenceSystem>>();
        }
        return this.namedReferenceSystem;
    }
}