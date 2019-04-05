public class DojoDropContainerHandler extends AbstractDojoWidgetBehavior
{
	private static final String FUNCTION_CONNECT_DROP_CONTAINER = "connectDojoDropContainer";
	private static final String JAVASCRIPT;
	private static final String JAVASCRIPT_ID;
	
	public static final String ACCEPT_NONE = AttributeModifier.VALUELESS_ATTRIBUTE_REMOVE;
	static {
		DojoPackagedTextTemplate template = new DojoPackagedTextTemplate(DojoDropContainer.class, DojoDropContainer.class.getSimpleName()+".js");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("connectDojoDropContainerFunction", FUNCTION_CONNECT_DROP_CONTAINER);
		JAVASCRIPT = template.asString(map);
		JAVASCRIPT_ID = template.getStaticKey();
	}
	private IModel acceptModel;
	
	private DojoDropContainer container;
	
	public DojoDropContainerHandler(IModel acceptModel)
	{	
		this.acceptModel = acceptModel;
	}
	
	protected void onBind()
	{
		super.onBind();
		getComponent().add(new AttributeModifier("accept", true, new PropertyModel(this, "acceptModel.object")));
		this.container = (DojoDropContainer)getComponent();
	}
	protected final void respond(AjaxRequestTarget target)
	{
		container.onAjaxModelUpdated(target);
	}
	
	protected DojoDropContainer getDojoDropContainer() {
		return this.container;
	}
	
	public void setRequire(RequireDojoLibs libs)
	{
		super.setRequire(libs);
		libs.add("dojo.dnd.Source");
	}
	
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		if (isDropCallbackEnabled() && getComponent().isVisibleInHierarchy()) {
			response.renderJavascript(JAVASCRIPT, JAVASCRIPT_ID);
			response.renderOnDomReadyJavascript(FUNCTION_CONNECT_DROP_CONTAINER+"('"+getComponent().getMarkupId()+"','"+getCallbackUrl()+"')");
		}
	}
	
	protected boolean isDropCallbackEnabled()
	{
		return true;
	}
	
	public IModel getAcceptModel()
	{
		return acceptModel;
	}
	
	public void setAcceptModel(IModel acceptModel)
	{
		this.acceptModel = acceptModel;
	}
}