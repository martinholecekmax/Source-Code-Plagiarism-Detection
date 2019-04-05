public class SelectToken extends AbstractNonEmptyToken<KitSelect> implements
		CDOMPrimaryToken<KitSelect>
{
	
	@Override
	public String getTokenName()
	{
		return "SELECT";
	}
	@Override
	public Class<KitSelect> getTokenClass()
	{
		return KitSelect.class;
	}
	@Override
	protected ParseResult parseNonEmptyToken(LoadContext context,
		KitSelect kitSelect, String value)
	{
		Formula formula = FormulaFactory.getFormulaFor(value);
		if (!formula.isValid())
		{
			return new ParseResult.Fail("Formula in " + getTokenName()
					+ " was not valid: " + formula.toString(), context);
		}
		kitSelect.setFormula(formula);
		return ParseResult.SUCCESS;
	}
	@Override
	public String[] unparse(LoadContext context, KitSelect kitSelect)
	{
		Formula f = kitSelect.getFormula();
		if (f == null)
		{
			return null;
		}
		return new String[] { f.toString() };
	}
}