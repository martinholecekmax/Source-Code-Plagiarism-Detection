public class LangBuilderMojo extends AbstractLiferayMojo {
	protected void doExecute() throws Exception {
		initPortal();
		new LangBuilder(langDir, langFile, langPlugin, langTranslate);
	}
	
	private String langDir;
	
	private String langFile;
	
	private boolean langPlugin;
	
	private boolean langTranslate;
}