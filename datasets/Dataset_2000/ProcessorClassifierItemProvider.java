public class ProcessorClassifierItemProvider extends ComponentClassifierItemProvider implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
		IItemPropertySource {
	
	public ProcessorClassifierItemProvider(AdapterFactory adapterFactory) {
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
	public String getText(Object object) {
		String label = ((ProcessorClassifier) object).getName();
		return label == null || label.length() == 0 ? getString("_UI_ProcessorClassifier_type")
				: getString("_UI_ProcessorClassifier_type") + " " + label;
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