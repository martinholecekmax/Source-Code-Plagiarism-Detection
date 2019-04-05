public class WOApplicationGenerator extends JavaClassGenerator {
	private static final String TEMPLATE_NAME = "Application.java.vm";
	private static final Logger logger = FlexoLogger.getLogger(WOApplicationGenerator.class.getPackage().getName());
	public WOApplicationGenerator(ProjectGenerator projectGenerator) {
		super(projectGenerator, projectGenerator.getProject().getDataModel().getWORepository().getCustomApplicationEntity());
	}
	@Override
	public Logger getGeneratorLogger() {
		return logger;
	}
	
	@Override
	public void rebuildDependanciesForResource(JavaFileResource resource) {
	}
	@Override
	public String getTemplateName() {
		return TEMPLATE_NAME;
	}
}