public class EcActionUpgradeTunnelingClaws extends EcActionUpgrade
{
	@Override
	public void init()
	{
		init(150, 150, 110, "Tunneling Claws");
	}
	@Override
	public void execute(EcBuildOrder s, EcEvolver e)
	{
				super.execute(s, e);
		s.roachWarrensInUse++;
	}
	@Override
	public boolean isInvalid(EcBuildOrder s)
	{
		if (s.roachWarrens-s.roachWarrensInUse == 0)
			return true;
		if (s.lairs == 0 && s.evolvingLairs == 0 && s.hives == 0 && s.evolvingHives == 0)
			return true;
		return false;
	}
	@Override
	public void afterTime(EcBuildOrder s, EcEvolver e)
	{
		s.tunnelingClaws = true;
		s.roachWarrensInUse--;
	}
	@Override
	public List<EcAction> requirements(EcState destination)
	{
		ArrayList<EcAction> l = new ArrayList<EcAction>();
		l.add(new EcActionBuildRoachWarren());
		l.add(new EcActionBuildLair());
		return l;
	}
}