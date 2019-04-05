public final class CompanionMod extends PObject
{
	
	public int getVariableApplied(final String var)
	{
		int result = -1;
		Map<String, Integer> varmap = getMapFor(MapKey.APPLIED_VARIABLE);
		if (varmap != null && result == -1 && varmap.get(var) != null)
		{
			result = varmap.get(var);
		}
		return result;
	}
	public boolean appliesToRace(Race r)
	{
		List<CDOMSingleRef<Race>> list = getListFor(ListKey.APPLIED_RACE);
		if (list != null)
		{
			for (CDOMSingleRef<Race> ref : list)
			{
				Race race = ref.resolvesTo();
				if (race.equals(r))
				{
					return true;
				}
			}
		}
		return false;
	}
	public int getLevelApplied(PCClass cl)
	{
		int result = -1;
		Map<CDOMSingleRef<? extends PCClass>, Integer> ac = getMapFor(MapKey.APPLIED_CLASS);
		if (ac != null)
		{
			for (Map.Entry<CDOMSingleRef<? extends PCClass>, Integer> me : ac
					.entrySet())
			{
				PCClass pcclass = me.getKey().resolvesTo();
				if (pcclass.getKeyName().equalsIgnoreCase(cl.getKeyName()))
				{
					result = me.getValue();
				}
			}
		}
		return result;
	}
}