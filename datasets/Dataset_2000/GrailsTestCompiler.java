public class GrailsTestCompiler extends Grailsc {
    public GrailsTestCompiler() {
        setEncoding("UTF-8");
    }
    @Override
    protected CompilationUnit makeCompileUnit() {
        ImportCustomizer importCustomizer = new ImportCustomizer();
        importCustomizer.addStarImports("grails.test.mixin");
        importCustomizer.addStarImports("org.junit");
        importCustomizer.addStaticStars("groovy.util.GroovyTestCase");
        ASTTransformationCustomizer astTransformationCustomizer = new ASTTransformationCustomizer(TestFor.class);
        configuration.addCompilationCustomizers(importCustomizer, astTransformationCustomizer);
        return super.makeCompileUnit();
    }
}