public class ContextInstanceImpl implements ContextInstance {
    private Map<String, Object> variables = new HashMap<String, Object>();
    public ContextInstanceImpl() {
    }
    @Override
    public Map<String, Object> getVariables() {
        return variables;
    }
    @Override
    public void setVariables(Map<String, Object> variables) {
        this.variables = variables;
    }
    public Object getVariable(String key) {
        return this.variables.get(key);
    }
    public void setVariable(String key, Object value) {
        this.variables.put(key, value);
    }
}