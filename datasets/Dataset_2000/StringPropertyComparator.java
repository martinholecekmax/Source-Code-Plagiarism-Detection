public class StringPropertyComparator<ObjectType> implements Comparator<ObjectType> {
    private String[] propertyNames = null;
    
    public StringPropertyComparator(String... propertyNames) {
        super();
        this.propertyNames = propertyNames;
    }
    
    public int compare(ObjectType o1, ObjectType o2) {
        if (o1 == null) {
            return o2 == null ? 0 : -1;
        }
        if (o2 == null) {
            return o1 == null ? 0 : +1;
        }
                for (String propertyName : propertyNames) {
            try {
                String v1 = StringUtils.trimToEmpty(BeanUtils.getProperty(o1, propertyName));
                int compv = v1.compareToIgnoreCase(BeanUtils.getProperty(o2, propertyName));
                if (compv != 0) {
                    return compv;
                }
            }
            catch (Exception ex) {
                throw new TabInternalErrorException(
                        "Problem while trying to get " + propertyName + " from " + o1.getClass().getSimpleName() + ": "
                                + ex.getMessage(), ex
                );
            }
        }
        return 0;
    }
}