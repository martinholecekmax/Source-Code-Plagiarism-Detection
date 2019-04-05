public class ViewCategoryTreeAction extends TreeViewAbstractAction
{
	private static final long serialVersionUID = 1L;
	public static final String BINDING = "bindingView";
	private Integer select;
	public String doBindingView() throws Exception
	{
		super.doExecute();
		return BINDING;
	}
	
	protected INodeSupplier getNodeSupplier() throws SystemException
	{
		return new CategoryNodeSupplier();
	}
	
	public Integer getSelect()
	{
		return select;
	}
	
	public void setSelect(Integer select)
	{
		this.select = select;
	}
}