public abstract class AbstractPropertyData<T> extends AbstractExtensionData implements PropertyData<T> {
    private static final long serialVersionUID = 1L;
    private String id;
    private String displayName;
    private String localName;
    private String queryName;
    private List<T> values;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDisplayName() {
        return displayName;
    }
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    public String getLocalName() {
        return localName;
    }
    public void setLocalName(String localName) {
        this.localName = localName;
    }
    public String getQueryName() {
        return queryName;
    }
    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }
    public List<T> getValues() {
        return values;
    }
    public void setValues(List<T> values) {
        if (values == null) {
            this.values = Collections.emptyList();
        } else {
            this.values = values;
        }
    }
    public void setValue(T value) {
        if (value == null) {
            values = Collections.emptyList();
        } else {
            values = new ArrayList<T>(1);
            values.add(value);
        }
    }
    public T getFirstValue() {
        if ((values != null) && (!values.isEmpty())) {
            return values.get(0);
        }
        return null;
    }
    @Override
    public String toString() {
        return "Property [id=" + id + ", display Name=" + displayName + ", local name=" + localName + ", query name="
                + queryName + ", values=" + values + "]" + super.toString();
    }
}