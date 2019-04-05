public final class HandlerConstructor implements Parameterized, ResourceModelComponent {
    private final Constructor<?> constructor;
    private final List<Parameter> parameters;
    
    HandlerConstructor(Constructor<?> constructor, List<Parameter> parameters) {
        this.constructor = constructor;
        this.parameters = parameters;
    }
    
    public Constructor<?> getConstructor() {
        return constructor;
    }
    @Override
    public List<Parameter> getParameters() {
        return parameters;
    }
    @Override
    public boolean requiresEntity() {
        for (Parameter p : getParameters()) {
            if (Parameter.Source.ENTITY == p.getSource()) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void accept(ResourceModelVisitor visitor) {
        visitor.visitResourceHandlerConstructor(this);
    }
    @Override
    public List<ResourceModelComponent> getComponents() {
        return null;
    }
}