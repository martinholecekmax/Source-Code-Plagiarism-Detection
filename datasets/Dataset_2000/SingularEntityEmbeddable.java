@Entity
@Table(name = "table", schema = "testSchema@keyspace")
public class SingularEntityEmbeddable
{
    @Id
    private Integer key;
    @Column(name = "field", nullable = false)
    private String field;
    @Column(name = "name")
    private String name;
    @Embedded
    private EmbeddableEntity embeddableEntity;
    @Embedded
    private EmbeddableEntityTwo embeddableEntityTwo;
    
    public Integer getKey()
    {
        return key;
    }
    
    public void setKey(Integer key)
    {
        this.key = key;
    }
    
    public String getField()
    {
        return field;
    }
    
    public void setField(String field)
    {
        this.field = field;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public EmbeddableEntity getEmbeddableEntity()
    {
        return embeddableEntity;
    }
    
    public void setEmbeddableEntity(EmbeddableEntity embeddableEntity)
    {
        this.embeddableEntity = embeddableEntity;
    }
    
    public EmbeddableEntityTwo getEmbeddableEntityTwo()
    {
        return embeddableEntityTwo;
    }
    
    public void setEmbeddableEntityTwo(EmbeddableEntityTwo embeddableEntityTwo)
    {
        this.embeddableEntityTwo = embeddableEntityTwo;
    }
}