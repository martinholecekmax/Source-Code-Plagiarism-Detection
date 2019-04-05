public class DeleteTemplateCommand extends ssCommand {
	private String templatePath;
	public DeleteTemplateCommand() {	
	}
	public DeleteTemplateCommand(String secUrl, String templatePath) {
	    this.setSecUrl(secUrl);
    	this.templatePath = templatePath;
    }
	@Override
    public boolean executeInSequence() {
        return true;
    }
	public String getTemplatePath() {
		return templatePath;
	}
}