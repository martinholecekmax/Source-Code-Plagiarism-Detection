public class TypeFacadeTest extends ContextTestCase
{
    @Project(mainCls="Hello")
    @Preferences(testClassSuffixes="Test")
    @Test
    public void isTestCase_should_return_false_when_regular_class() throws CoreException
    {
        assertThat(TypeFacade.isTestCase(context.getCompilationUnit("Hello"))).isFalse();
    }
    @Project(mainCls="HelloTest")
    @Preferences(testClassSuffixes="Test")
    @Test
    public void isTestCase_should_return_true_when_class_has_test_suffix() throws JavaModelException
    {
        assertThat(TypeFacade.isTestCase(context.getCompilationUnit("HelloTest"))).isTrue();
    }
    @Project(mainCls="TestHello")
    @Preferences(testClassPrefixes="Test")
    @Test
    public void isTestCase_should_return_true_when_class_has_test_prefix() throws JavaModelException
    {
        assertThat(TypeFacade.isTestCase(context.getCompilationUnit("TestHello"))).isTrue();
    }
}