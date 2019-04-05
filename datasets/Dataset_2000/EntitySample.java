@Entity
@Table(name = "table", schema = "testSchema")
@NamedQuery(name = "test.named.query", query = "Select t from TestEntity t where t.field = :field")
@NamedQueries({
        @NamedQuery(name = "test.named.queries1", query = "Select t1 from TestEntity t1 where t1.field = :field"),
        @NamedQuery(name = "test.named.queries2", query = "Select t2 from TestEntity t2 where t2.field = :field") })
@NamedNativeQuery(name = "test.native.query", query = "Select native from TestEntity native where native.field = :field")
@NamedNativeQueries({
        @NamedNativeQuery(name = "test.native.query1", query = "Select native1 from TestEntity native1 where native1.field = :field"),
        @NamedNativeQuery(name = "test.native.query2", query = "Select native2 from TestEntity native2 where native2.field = :field") })
public class EntitySample
{
    @Id
    private Integer key;
    @Column(name = "field")
    private String field;
    
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
}