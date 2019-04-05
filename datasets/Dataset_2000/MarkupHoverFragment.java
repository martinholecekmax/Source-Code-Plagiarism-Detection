public class MarkupHoverFragment  extends DefaultGeneratorFragment
{
	@Override
	public Set<Binding> getGuiceBindingsUi(Grammar grammar) {
		BindFactory bindFactory = new BindFactory();
		bindFactory.addTypeToType(IEObjectHover.class.getName(), MarkupHover.class.getName());
		bindFactory.addTypeToType(IEObjectHoverProvider.class.getName(), MarkupHoverProvider.class.getName());
		bindFactory.addTypeToType(IEObjectDocumentationProvider.class.getName(), BaseDocumentationProvider.class.getName());
		return bindFactory.getBindings();
	}
}