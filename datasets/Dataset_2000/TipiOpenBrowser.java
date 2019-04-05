public class TipiOpenBrowser extends TipiVaadinActionImpl {
   private static final long serialVersionUID = -7235686945038762814L;
   private final static Logger logger = LoggerFactory
		.getLogger(TipiOpenBrowser.class);
	
    protected void execute(TipiEvent event) throws TipiBreakException, TipiException {
        Object url  = getEvaluatedParameterValue("url", event);
		Object newWindow = getEvaluatedParameterValue("newWindow",
				event);
		boolean openNewWindow = true;
		if(newWindow!=null && (newWindow instanceof Boolean)) {
			openNewWindow =  ((Boolean)newWindow).booleanValue();
		}
		try {
			URL u = new URL(""+url);
			if (openNewWindow) {
				getApplication().getMainWindow().open(new ExternalResource(u),"_blank");
			} else {
				getApplication().getMainWindow().open(new ExternalResource(u));
			}
		} catch (MalformedURLException e) {
			logger.warn("Malformed URL: "+url +". Ok, try a file:");
						File base = ((VaadinTipiContext)getContext()).getInstallationFolder();
			logger.debug("Base resolved to: "+base.getAbsolutePath());
			File fil = new File(base,""+url);
			logger.debug("File resolved to: "+fil.getAbsolutePath());
			if(fil.exists()) {
				final FileResource fr = new FileResource(fil,getApplication());
				if (openNewWindow) {
					getApplication().getMainWindow().open(fr,"_blank");
				} else {
					getApplication().getMainWindow().open(fr);
				}
			}
		}
    }
}