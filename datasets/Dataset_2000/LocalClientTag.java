public class LocalClientTag extends BaseNavajoTag {
	private final static Logger logger = LoggerFactory
			.getLogger(LocalClientTag.class);
	public int doStartTag() throws JspException {
		NavajoServerContext nc = (NavajoServerContext) getPageContext().findAttribute("serverContext");
		try {
			if(nc!=null) {
				nc.setupClient();
			} else {
				logger.error("No serverContext found!");
			}
		} catch (Throwable e) {
			logger.error("Error configuring client tag: ",e);
		}
		return EVAL_BODY_INCLUDE;
	}
}