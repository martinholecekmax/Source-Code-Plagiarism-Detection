public class TerminateEventDefinitionItemProvider extends EventDefinitionItemProvider implements
        IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
        IItemLabelProvider, IItemPropertySource {
    
    public TerminateEventDefinitionItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }
    
    @Override
    public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
        if (itemPropertyDescriptors == null) {
            super.getPropertyDescriptors(object);
        }
        return itemPropertyDescriptors;
    }
    
    @Override
    public Object getImage(Object object) {
        try {
            return overlayImage(object,
                    getResourceLocator().getImage("full/obj16/TerminateEventDefinition.png"));
        } catch (java.util.MissingResourceException e) {
            return overlayImage(object,
                    getResourceLocator().getImage("full/obj16/TerminateEventDefinition.gif"));
        }
    }
    
    @Override
    public String getText(Object object) {
        String label = ((TerminateEventDefinition) object).getId();
        return label == null || label.length() == 0 ? getString("_UI_TerminateEventDefinition_type")
                : getString("_UI_TerminateEventDefinition_type") + " " + label;
    }
    
    @Override
    public void notifyChanged(Notification notification) {
        updateChildren(notification);
        super.notifyChanged(notification);
    }
    
    @Override
    protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
        super.collectNewChildDescriptors(newChildDescriptors, object);
    }
}