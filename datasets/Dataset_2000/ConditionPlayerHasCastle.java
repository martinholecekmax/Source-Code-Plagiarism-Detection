public final class ConditionPlayerHasCastle extends Condition
{
	private final int _castle;
	
	public ConditionPlayerHasCastle(int castle)
	{
		_castle = castle;
	}
	
	@Override
	public boolean testImpl(Env env)
	{
		if (!(env.player instanceof L2PcInstance))
			return false;
		L2Clan clan = ((L2PcInstance)env.player).getClan();
		if (clan == null)
			return _castle == 0;
				if (_castle == -1) return clan.getHasCastle() > 0;
		return clan.getHasCastle() == _castle;
	}
}