public class JavaNCSSProjectIndividualReport extends AbstractProjectReport<AbstractProject<?, ?>> implements ProminentProjectAction {
    public JavaNCSSProjectIndividualReport(AbstractProject<?, ?> project) {
        super(project);
    }
    protected Class<? extends AbstractBuildReport> getBuildActionClass() {
        return JavaNCSSBuildIndividualReport.class;
    }
}