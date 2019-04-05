public class DBObjectIterableProxy extends BasicDBList {
    public static DBObjectIterableProxy create(Iterable iterable, PropertyDescriptor propertyDescriptor) {
        if(iterable == null) {
            throw new RuntimeException("Passed object is null");
        }
        DBObjectIterableProxy dbObjectIterableProxy = new DBObjectIterableProxy();
        Class genericClass = null;
        if (propertyDescriptor != null) {
            genericClass = BaseProxy.getGenericListClass(propertyDescriptor.getReadMethod().getGenericReturnType());
        }
        for (Object nextObj : iterable) {
            Object obj = BaseProxy.passValue(nextObj);
            if (obj instanceof DBObjectProxy) {                                 if (genericClass != null && !BaseProxy.getClassName(nextObj).equals(genericClass.getName())) {
                    Map<String, String> genericInfo = new HashMap<String, String>();
                    genericInfo.put("implementation", BaseProxy.getClassName(nextObj));
                    ((DBObjectProxy) obj).addGenericInfo(genericInfo);
                }
            }
            dbObjectIterableProxy.add(obj);
        }
        return dbObjectIterableProxy;
    }
}