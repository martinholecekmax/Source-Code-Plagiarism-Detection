public class DisplayLocationToken extends
		AbstractNonEmptyToken<AbilityCategory> implements
		CDOMPrimaryToken<AbilityCategory>
{
	@Override
	public String getTokenName()
	{
		return "DISPLAYLOCATION";
	}
	@Override
	protected ParseResult parseNonEmptyToken(LoadContext context,
			AbilityCategory ac, String value)
	{
		
		String loc;
		if (value.startsWith("in_"))
		{
			loc = LanguageBundle.getString(value);
		}
		else
		{
			loc = value;
		}
		ac.setDisplayLocation(DisplayLocation.getConstant(loc));
		return ParseResult.SUCCESS;
	}
	@Override
	public String[] unparse(LoadContext context, AbilityCategory ac)
	{
		DisplayLocation location = ac.getDisplayLocation();
		if (location == null)
		{
			return null;
		}
		return new String[] { location.toString() };
	}
	@Override
	public Class<AbilityCategory> getTokenClass()
	{
		return AbilityCategory.class;
	}
}