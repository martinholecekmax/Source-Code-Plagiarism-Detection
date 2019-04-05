public class GroovyPageClassLoader extends GroovyClassLoader {
    public GroovyPageClassLoader() {
            }
    public GroovyPageClassLoader(ClassLoader loader) {
        super(loader);
    }
    public GroovyPageClassLoader(GroovyClassLoader parent) {
        super(parent);
    }
    public GroovyPageClassLoader(ClassLoader parent, CompilerConfiguration config, boolean useConfigurationClasspath) {
        super(parent, config, useConfigurationClasspath);
    }
    public GroovyPageClassLoader(ClassLoader loader, CompilerConfiguration config) {
        super(loader, config);
    }
    
    @Override
    protected CompilationUnit createCompilationUnit(CompilerConfiguration config, CodeSource source) {
        CompilationUnit cu = super.createCompilationUnit(config, source);
        GroovyPageInjectionOperation operation;
        operation = new GroovyPageInjectionOperation();
        cu.addPhaseOperation(operation, Phases.CANONICALIZATION);
        return cu;
    }
}