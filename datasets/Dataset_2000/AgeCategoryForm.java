public class AgeCategoryForm extends CreamLookupForm
{
    protected void initScreen()
    {
        setModuleType(LOOKUP);
        setModuleName("AGE_CATEGORY");
        setIdName(AgeCategoryPeer.AGE_CAT_ID);
        setFormIdName("agecatid");
    }
    protected boolean getEntry(Criteria criteria, Context context)
    {
        try
        {
            AgeCategory entry = (AgeCategory) AgeCategoryPeer.doSelect(criteria).get(0);
            context.put("entry", entry);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
}