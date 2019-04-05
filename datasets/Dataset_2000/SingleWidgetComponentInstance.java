@Deprecated
public class SingleWidgetComponentInstance extends PartialComponentInstance implements DeletableObject, Serializable {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(SingleWidgetComponentInstance.class.getPackage().getName());
	public SingleWidgetComponentInstance(SingleWidgetComponentDefinition component, IEWOComponent container) {
		super(component, container);
	}
	public SingleWidgetComponentInstance(FlexoComponentBuilder builder) {
		super(builder);
	}
	@Override
	public Vector<FlexoModelObject> getAllEmbeddedDeleted() {
		return EmptyVector.EMPTY_VECTOR(FlexoModelObject.class);
	}
	@Override
	public boolean isDeleted() {
		return isDeleted;
	}
	@Override
	public String getFullyQualifiedName() {
		return "SingleWidgetInstance_" + getComponentDefinition().getComponentName();
	}
	
	@Override
	public String getClassNameKey() {
		return "single_widget_component_instance";
	}
}