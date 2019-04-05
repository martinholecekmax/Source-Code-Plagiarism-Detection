public class SurefireReportMojo
    extends AbstractSurefireReportMojo
{
    
    private String outputName;
    
    private boolean alwaysGenerateSurefireReport;
    
    private boolean skipSurefireReport;
    protected File getSurefireReportsDirectory( MavenProject subProject )
    {
        String buildDir = subProject.getBuild().getDirectory();
        return new File( buildDir + "/surefire-reports" );
    }
    public String getOutputName()
    {
        return outputName;
    }
    protected boolean isSkipped()
    {
        return skipSurefireReport;
    }
    protected boolean isGeneratedWhenNoResults()
    {
        return alwaysGenerateSurefireReport;
    }
}