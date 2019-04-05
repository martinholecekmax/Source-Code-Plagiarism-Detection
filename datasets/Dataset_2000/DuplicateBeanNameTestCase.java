public class DuplicateBeanNameTestCase extends AbstractBadConfigTestCase
{
    public DuplicateBeanNameTestCase(ConfigVariant variant, String configResources)
    {
        super(variant, configResources);     
    }
    @Parameters
    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]{
            {ConfigVariant.SERVICE, "org/mule/config/spring/parsers/duplicate-bean-name-test.xml"},            
        });
    }      
    @Test
    public void testBeanError() throws Exception
    {
        assertErrorContains("Bean name 'child1' is already used in this <beans> element");
    }
}