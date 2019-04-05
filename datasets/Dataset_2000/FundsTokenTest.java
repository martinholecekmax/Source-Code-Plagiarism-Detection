public class FundsTokenTest extends AbstractKitTokenTestCase<KitFunds>
{
	static FundsToken token = new FundsToken();
	static CDOMSubLineLoader<KitFunds> loader = new CDOMSubLineLoader<KitFunds>(
			"TABLE", KitFunds.class);
	@Override
	public Class<KitFunds> getCDOMClass()
	{
		return KitFunds.class;
	}
	@Override
	public CDOMSubLineLoader<KitFunds> getLoader()
	{
		return loader;
	}
	@Override
	public CDOMPrimaryToken<KitFunds> getToken()
	{
		return token;
	}
	@Test
	public void testRoundRobinName() throws PersistenceLayerException
	{
		runRoundRobin("Table Name");
	}
}