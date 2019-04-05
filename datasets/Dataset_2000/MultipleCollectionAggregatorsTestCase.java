public class MultipleCollectionAggregatorsTestCase extends AbstractServiceAndFlowTestCase
{
    @Parameters
    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]{
            {ConfigVariant.SERVICE, "multiple-collection-aggregators-config-service.xml"},
            {ConfigVariant.FLOW, "multiple-collection-aggregators-config-flow.xml"}
        });
    }
    public MultipleCollectionAggregatorsTestCase(ConfigVariant variant, String configResources)
    {
        super(variant, configResources);
    }
    @Test
    public void testStartsCorrectly()
    {
        assertTrue(muleContext.isStarted());
    }
}