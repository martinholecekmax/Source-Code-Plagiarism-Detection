public class GoResolveBuiltinTypesTest extends GoPsiResolveTestCase {
    @Override
    protected String getTestDataRelativePath() {
        return super.getTestDataRelativePath() + "builtins/";
    }
    @Override
    protected void assertTest() {
        assertNotNull("Source position is not at a reference", ref);
        PsiElement resolvedDefinition = ref.resolve();
        assertNotNull("The resolving should have been been a success",
                      resolvedDefinition);
        while (resolvedDefinition.getStartOffsetInParent() == 0) {
            resolvedDefinition = resolvedDefinition.getParent();
        }
        getAs(GoTypeSpec.class, resolvedDefinition);
    }
    public void testBuiltinTypes() throws Exception {
        doTest();
    }
    public void testBuiltinConversion() throws Exception {
        doTest();
    }
    public void testVarBuiltinType() throws Exception {
        doTest();
    }
    public void testVarMethodType() throws Exception {
        doTest();
    }
    public void testParameterType() throws Exception {
        doTest();
    }
}