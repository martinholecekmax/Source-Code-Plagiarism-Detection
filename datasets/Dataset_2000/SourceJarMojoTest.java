public class SourceJarMojoTest
    extends AbstractSourcePluginTestCase
{
    protected String getGoal()
    {
        return "jar";
    }
    public void testDefaultConfiguration()
        throws Exception
    {
        doTestProjectWithSourceArchive( "project-001",
                                        new String[]{ "default-configuration.properties", "foo/project001/App.java",
                                            "foo/project001/", "foo/", "META-INF/MANIFEST.MF", "META-INF/" },
                                        "sources" );
    }
    public void testExcludes()
        throws Exception
    {
        doTestProjectWithSourceArchive( "project-003",
                                        new String[]{ "default-configuration.properties", "foo/project003/App.java",
                                            "foo/project003/", "foo/", "META-INF/MANIFEST.MF", "META-INF/" },
                                        "sources" );
    }
    public void testNoSources()
        throws Exception
    {
        executeMojo( "project-005", "sources" );
                final File expectedFile = getTestTargetDir( "project-005" );
        assertFalse( "Source archive should not have been created[" + expectedFile.getAbsolutePath() + "]",
                     expectedFile.exists() );
    }
    public void testIncludes()
        throws Exception
    {
        doTestProjectWithSourceArchive( "project-007", new String[]{ "templates/configuration-template.properties",
            "foo/project007/App.java", "templates/", "foo/project007/", "foo/", "META-INF/MANIFEST.MF", "META-INF/"
        }, "sources" );
    }
    public void testIncludePom()
        throws Exception
    {
        doTestProjectWithSourceArchive( "project-009", new String[]{ "default-configuration.properties", "pom.xml",
            "foo/project009/App.java", "foo/project009/", "foo/", "META-INF/MANIFEST.MF", "META-INF/" }, "sources" );
    }
}