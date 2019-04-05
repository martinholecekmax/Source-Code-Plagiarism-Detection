public interface AssociationAttributeBinding extends AttributeBinding {
	
	public CascadeStyle getCascadeStyle();
	
	public void setCascadeStyles(Iterable<CascadeStyle> cascadeStyles);
	public FetchTiming getFetchTiming();
	public void setFetchTiming(FetchTiming fetchTiming);
	public FetchStyle getFetchStyle();
	public void setFetchStyle(FetchStyle fetchStyle);
	
	@Deprecated
	@SuppressWarnings( {"JavaDoc"})
	public FetchMode getFetchMode();
}