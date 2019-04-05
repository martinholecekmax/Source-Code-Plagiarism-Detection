public class SCIMAttributeMapping {
    public static Map<String, String> scimAttributeMap = new ConcurrentHashMap<String, String>();
    public static SCIMAttributeMapping scimAttributemapping = null;
    public static SCIMAttributeMapping getInstance() {
        if(scimAttributemapping == null){
            synchronized (SCIMAttributeMapping.class) {
                if(scimAttributemapping == null){
                    scimAttributemapping = new SCIMAttributeMapping();
                    return scimAttributemapping;
                }
                return scimAttributemapping;
            }
        }
        return scimAttributemapping;
    }
    public SCIMAttributeMapping(){
        scimAttributeMap.put("userName", SCIMSchemaDefinitions.USER_NAME.getName());
        scimAttributeMap.put("","");
    }
}