class ModifiableSimpleFeaturetype extends DefaultSimpleFeatureType implements ModifiableType {
    private AttributeType parent;
    public ModifiableSimpleFeaturetype(final Name name, final List<AttributeDescriptor> schema, 
            final GeometryDescriptor defaultGeometry, final boolean isAbstract,
            final List<Filter> restrictions, final AttributeType superType, final InternationalString description) {
        super(name, schema, defaultGeometry, isAbstract, restrictions, superType, description);
    }
    @Override
    public void changeProperty(final int index, PropertyDescriptor desc) {
        descriptors[index] = desc;
        types[index] = (AttributeType) desc.getType();
    }
    @Override
    public List<PropertyDescriptor> getDescriptors() {
        return descriptorsList;
    }
    @Override
    public void changeParent(AttributeType parent) {
        this.parent = parent;
    }
    @Override
    public AttributeType getSuper() {
        if(this.parent != null){
            return parent;
        }else{
            return super.getSuper();
        }
    }
}