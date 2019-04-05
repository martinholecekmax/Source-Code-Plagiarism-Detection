public interface ShoppingItemFieldModel extends BaseModel<ShoppingItemField> {
	
	
	public long getPrimaryKey();
	
	public void setPrimaryKey(long pk);
	
	public long getItemFieldId();
	
	public void setItemFieldId(long itemFieldId);
	
	public long getItemId();
	
	public void setItemId(long itemId);
	
	@AutoEscape
	public String getName();
	
	public void setName(String name);
	
	@AutoEscape
	public String getValues();
	
	public void setValues(String values);
	
	@AutoEscape
	public String getDescription();
	
	public void setDescription(String description);
	public boolean isNew();
	public void setNew(boolean n);
	public boolean isCachedModel();
	public void setCachedModel(boolean cachedModel);
	public boolean isEscapedModel();
	public void setEscapedModel(boolean escapedModel);
	public Serializable getPrimaryKeyObj();
	public ExpandoBridge getExpandoBridge();
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);
	public Object clone();
	public int compareTo(ShoppingItemField shoppingItemField);
	public int hashCode();
	public ShoppingItemField toEscapedModel();
	public String toString();
	public String toXmlString();
}