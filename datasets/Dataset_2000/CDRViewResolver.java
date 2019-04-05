public class CDRViewResolver extends InternalResourceViewResolver {
	private static final Logger LOG = LoggerFactory.getLogger(CDRViewResolver.class);
	protected String baseView;
	protected String subViewPrefix;
	protected AbstractUrlBasedView buildView(String viewName) throws Exception {
		LOG.debug("In CDR View Resolver:" + viewName);
		this.getAttributesMap().put("contentPage", subViewPrefix + viewName + this.getSuffix());
		return super.buildView(baseView);
	}
	public String getBaseView() {
		return baseView;
	}
	public void setBaseView(String baseView) {
		this.baseView = baseView;
	}
	public String getSubViewPrefix() {
		return subViewPrefix;
	}
	public void setSubViewPrefix(String subViewPrefix) {
		this.subViewPrefix = subViewPrefix;
	}
}