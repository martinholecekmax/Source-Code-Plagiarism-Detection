public class AITServer01
{
	public static void main(String args[])
	{
		try
		{
			ORBInterface.initORB(args, null);
			OAInterface.initOA();
			AITServiceImpl01 aitServiceImpl = new AITServiceImpl01();
			ServicePOATie servant = new ServicePOATie(aitServiceImpl);
			OAInterface.objectIsReady(servant);
			Service service = ServiceHelper.narrow(OAInterface.corbaReference(servant));
			ObjectUidStore.storeUid(args[args.length - 2], aitServiceImpl.get_uid());
			ServerIORStore.storeIOR(args[args.length - 1], ORBInterface.orb().object_to_string(service));
			System.out.println("Ready");
			ORBInterface.run();
		}
		catch (Exception exception)
		{
			System.err.println("AITServer01.main: " + exception);
			exception.printStackTrace(System.err);
		}
	}
}