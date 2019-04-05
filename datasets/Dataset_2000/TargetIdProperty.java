public class TargetIdProperty extends AbstractProperty
{
    
    public TargetIdProperty(ServiceRegistry serviceRegistry, CMISConnector connector)
    {
        super(serviceRegistry, connector, PropertyIds.TARGET_ID);
    }
    public Serializable getValueInternal(CMISNodeInfo nodeInfo)
    {
        NodeRef targetNodeRef = nodeInfo.getAssociationRef().getTargetRef();
        return createNodeInfo(targetNodeRef).getObjectId();
    }
}