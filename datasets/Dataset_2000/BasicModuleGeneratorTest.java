public class BasicModuleGeneratorTest extends AbstractCodegenTestCase
{
    @Test
    public void hasCommonModules() throws Exception
    {
        Set<Class> moduleKeys = pluginModuleCreatorRegistry.getModuleCreatorsForProduct(PluginModuleCreatorRegistry.JIRA)
                .keySet();
        assertTrue(moduleKeys.contains(WorkflowPostFunctionModuleCreator.class));
        assertTrue(moduleKeys.contains(ServletFilterModuleCreator.class));
    }

}