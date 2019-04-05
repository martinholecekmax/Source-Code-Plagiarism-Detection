public class RaceTokenTest extends AbstractKitTokenTestCase<KitRace>
{
	static RaceToken token = new RaceToken();
	static CDOMSubLineLoader<KitRace> loader = new CDOMSubLineLoader<KitRace>(
			"SKILL", KitRace.class);
	@Override
	public Class<KitRace> getCDOMClass()
	{
		return KitRace.class;
	}
	@Override
	public CDOMSubLineLoader<KitRace> getLoader()
	{
		return loader;
	}
	@Override
	public CDOMPrimaryToken<KitRace> getToken()
	{
		return token;
	}
	@Test
	public void testInvalidInputEmptyCount() throws PersistenceLayerException
	{
		assertTrue(parse("Fireball"));
		assertConstructionError();
	}
	@Test
	public void testInvalidInputOnlyOne() throws PersistenceLayerException
	{
		primaryContext.ref.constructCDOMObject(Race.class, "Fireball");
		secondaryContext.ref.constructCDOMObject(Race.class, "Fireball");
		primaryContext.ref.constructCDOMObject(Race.class, "English");
		secondaryContext.ref.constructCDOMObject(Race.class, "English");
		assertTrue(parse("Fireball,English"));
		assertConstructionError();
	}
	@Test
	public void testRoundRobinSimple() throws PersistenceLayerException
	{
		primaryContext.ref.constructCDOMObject(Race.class, "Fireball");
		secondaryContext.ref.constructCDOMObject(Race.class, "Fireball");
		runRoundRobin("Fireball");
	}
}