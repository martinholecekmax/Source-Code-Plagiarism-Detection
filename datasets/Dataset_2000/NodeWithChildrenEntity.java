public class NodeWithChildrenEntity extends NodeBackedEntity
{
    private List<NameAndCreatedAt> children;
        private Long childrenTypeQNameId;
    
    public NodeWithChildrenEntity()
    {
    }
    
    public NodeWithChildrenEntity(Long parentNodeId, Long nameQNameId, Long contentTypeQNameId, Long childrenTypeQNameId)
    {
       super(parentNodeId, nameQNameId, contentTypeQNameId);
       this.childrenTypeQNameId = childrenTypeQNameId;
    }
    
    public List<NameAndCreatedAt> getChildren() 
    {
       return children;
    }
    public void setChildren(List<NameAndCreatedAt> children) 
    {
       this.children = children;
    }
    
    public Long getChildrenTypeQNameId() 
    {
       return childrenTypeQNameId;
    }
    public static class NameAndCreatedAt
    {
       private final Long nodeId;
       private final String name;
       private final String createdAt;
       public NameAndCreatedAt(Long nodeId, String name, String createdAt)
       {
          this.nodeId = nodeId;
          this.name = name;
          this.createdAt = createdAt;
       }
       public Long getNodeId() 
       {
          return nodeId;
       }
       public String getName()
       {
          return name;
       }
       public String getCreatedAt()
       {
          return createdAt;
       }
    }
}