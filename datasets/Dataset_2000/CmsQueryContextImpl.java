abstract class CmsQueryContextImpl implements CmsQueryContext, Serializable{
	
	private static final long serialVersionUID = -9008341995480272009L;
	private int offset = 0;
	private int limit = CmsQueryContext.UNLIMITED;
	public int getLimit() {
		return limit;
	}
	public int getOffset() {
		return offset;
	}
	private RenderProperties renderProperties = new RenderPropertiesImpl();
	private Map<String, Order> orderProperties = new LinkedHashMap<String, Order>();
	
	public RenderProperties getRenderProperties()
	{
		return renderProperties;
	}
	
	public Map<String, Order> getOrderProperties() {
		return orderProperties;
	}
	public void resetOrderProperties()
	{
		if (orderProperties != null){
			orderProperties.clear();
		}
	}
	public void addOrderProperty(String propertyPath, Order order)
	{
		if (StringUtils.isNotBlank(propertyPath) && order != null){
			if (orderProperties == null){
				orderProperties = new HashMap<String, Order>();
			}
				orderProperties.put(propertyPath, order);
		}
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public void setOffset(int offset) {
		this.offset = offset;	
	}
	public void setOffsetAndLimit(int offset, int limit) {
		setOffset(offset);
		setLimit(limit);
	}
	public void removeOrderProperty(String propertyPath) {
		if (StringUtils.isNotBlank(propertyPath) && orderProperties != null && orderProperties.containsKey(propertyPath)){
			orderProperties.remove(propertyPath);
		}
	}
}