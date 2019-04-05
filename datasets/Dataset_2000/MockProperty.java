public class MockProperty implements Property {
    private final String _name;
    private final Object _value;
    private final Scope _scope;
    private Set<String> _labels = Collections.synchronizedSet(new TreeSet<String>());
    public MockProperty(String name, Object value, Scope scope) {
        _name = name;
        _value = value;
        _scope = scope;
    }
    
    @Override
    public String getName() {
        return _name;
    }
    
    @Override
    public Object getValue() {
        return _value;
    }
    
    @Override
    public Scope getScope() {
        return _scope;
    }
    
    @Override
    public Set<String> getLabels() {
        return Collections.unmodifiableSet(_labels);
    }
    
    @Override
    public Property addLabels(String... labels) {
        for (String label : labels) {
            label = normalizeLabel(label);
            if (label != null) {
                _labels.add(label);
            }
        }
        return this;
    }
    
    @Override
    public Property removeLabels(String... labels) {
        for (String label : labels) {
            label = normalizeLabel(label);
            if (label != null) {
                _labels.remove(label);
            }
        }
        return this;
    }
    
    @Override
    public boolean hasLabel(String label) {
        label = normalizeLabel(label);
        return label != null && _labels.contains(label);
    }
    private String normalizeLabel(String label) {
        label = Strings.trimToNull(label);
        if (label != null) {
            label = label.toLowerCase();
        }
        return label;
    }
}