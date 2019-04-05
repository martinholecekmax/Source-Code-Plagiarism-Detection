public class TestCaseStatusLocale implements LocaleDescriptable
{
	private TestCaseStatusLocaleId	id;
	private String					name;
	private Integer					sortOrder;
	private boolean					deleted;
	public TestCaseStatusLocale()
	{
	}
	public TestCaseStatusLocale(TestCaseStatusLocaleId id, String name, Integer sortOrder)
	{
		this.id = id;
		this.name = name;
		this.sortOrder = sortOrder;
	}
	public TestCaseStatusLocaleId getId()
	{
		return this.id;
	}
	public void setId(TestCaseStatusLocaleId id)
	{
		this.id = id;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Integer getSortOrder()
	{
		return this.sortOrder;
	}
	public void setSortOrder(Integer sortOrder)
	{
		this.sortOrder = sortOrder;
	}
	@Override
	public Integer getEntityId()
	{
		return getId().getTestCaseStatusId();
	}
	@Override
	public String getLocaleCode()
	{
		return getId().getLocaleCode();
	}
	public void setDeleted(boolean deleted)
	{
		this.deleted = deleted;
	}
	public boolean isDeleted()
	{
		return deleted;
	}
}