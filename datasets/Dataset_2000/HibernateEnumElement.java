public class HibernateEnumElement extends TechnologyModuleBrowserElement<HibernateEnum> {
	public HibernateEnumElement(HibernateEnum hibernateEnum, ProjectBrowser browser, BrowserElement parent) {
		super(hibernateEnum, browser, parent);
	}
	
	@Override
	protected void buildChildrenVector() {
	}
	
	@Override
	public Icon getIcon() {
		return HibernateIconLibrary.ENUM_ICON;
	}
}