@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DeletedEntities", namespace = "http:    "entity"
})
public class DeletedEntities
    extends CdmCollections
    implements Serializable
{
    private final static long serialVersionUID = 1L;
    @XmlElement(name = "Entity")
    protected List<GenericEntity> entity;
    
    public List<GenericEntity> getEntity() {
        if (entity == null) {
            entity = new ArrayList<GenericEntity>();
        }
        return this.entity;
    }
    
    public void setEntity(List<GenericEntity> entity) {
        this.entity = entity;
    }
}