public class Java5Test extends DroolsTestCase {
    public void testJava5Rule() throws Exception {
        final String javaVersion = System.getProperty( "java.specification.version" );
                        if ( javaVersion.equals( "1.4" ) ) {
            System.out.println( "Skipping Java 1.5 tests - current JDK not compatible" );
            return;
        }
        final PackageBuilderConfiguration conf = new PackageBuilderConfiguration();
        JavaDialectConfiguration javaConf = ( JavaDialectConfiguration ) conf.getDialectConfiguration( "java" );
        javaConf.setCompiler( JavaDialectConfiguration.ECLIPSE );
        javaConf.setJavaLanguageLevel( "1.5" );
        final PackageBuilder builder = new PackageBuilder( );
        builder.addPackageFromDrl( new InputStreamReader( this.getClass().getResourceAsStream( "java5_rule.drl" ) ) );
        assertFalse( builder.hasErrors() );
    }
    public void testJava14Defaults() throws Exception {
        final PackageBuilderConfiguration conf = new PackageBuilderConfiguration();
        JavaDialectConfiguration javaConf = ( JavaDialectConfiguration ) conf.getDialectConfiguration( "java" );
        javaConf.setCompiler( JavaDialectConfiguration.JANINO );
        final PackageBuilder builder = new PackageBuilder( conf );
        builder.addPackageFromDrl( new InputStreamReader( this.getClass().getResourceAsStream( "java5_rule.drl" ) ) );
        assertTrue( builder.hasErrors() );
    }
}