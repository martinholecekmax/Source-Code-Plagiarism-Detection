public abstract class StyleDocGenerator extends DGLatexGenerator<FlexoProject> {
	private String styleName;
	public StyleDocGenerator(ProjectDocLatexGenerator projectGenerator, FlexoProject source, String styleName) {
		super(projectGenerator, source);
		this.styleName = styleName;
	}
	
	@Override
	public void buildResourcesAndSetGenerators(DGRepository repository, Vector<CGRepositoryFileResource> resources) {
				StyleLatexFileResource res = (StyleLatexFileResource) getProject().resourceForKey(ResourceType.LATEX_FILE,
				LatexFileResource.nameForRepositoryAndIdentifier(repository, getIdentifier()));
		if (res != null && res.getCGFile() == null) {
			res.delete(false);
			res = null;
		}
		if (res == null) {
			res = GeneratedFileResourceFactory.createNewStyleLatexFileResource(repository, this,
					getFileName().endsWith(getFileExtension()) ? getFileName() : getFileName() + getFileExtension());
			if (logger.isLoggable(Level.FINE)) {
				logger.fine("Created Style LATEX resource " + res.getName());
			}
		} else {
			res.setGenerator(this);
			if (logger.isLoggable(Level.FINE)) {
				logger.fine("Successfully retrieved Style LATEX resource " + res.getName());
			}
		}
		res.registerObserverWhenRequired();
		resources.add(res);
	}
	
	@Override
	public void generate(boolean forceRegenerate) {
		if (logger.isLoggable(Level.FINE)) {
			logger.fine("Called StyleDocGenerator.generate(forceRegenerate)");
		}
		super.generate(forceRegenerate);
	}
	
	@Override
	public String getFileName() {
		return styleName;
	}
	
	@Override
	public String getIdentifier() {
		return "Style-Latex-" + getStyleName();
	}
	public String getStyleName() {
		return styleName;
	}
	public void setStyleName(String styleName) {
		this.styleName = styleName;
	}
	
	@Override
	public String getFileExtension() {
		return ".sty";
	}
}