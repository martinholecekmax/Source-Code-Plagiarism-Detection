public class EntityBeanInfo extends EnterpriseBeanInfo {
    public String abstractSchemaName;
    public String primKeyClass;
    public String primKeyField;
    public String persistenceType;
    public String reentrant;
    public final List<String> cmpFieldNames = new ArrayList<String>();
    public final List<CmrFieldInfo> cmrFields = new ArrayList<CmrFieldInfo>();
    public int cmpVersion;
    public final List<QueryInfo> queries = new ArrayList<QueryInfo>();
    public EntityBeanInfo() {
        type = ENTITY;
    }
}