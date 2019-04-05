public final class BrowserFieldAuthDialogWrapper extends AuthDialogWrapper {
	
	private BrowserField browserField;
	
	public BrowserFieldAuthDialogWrapper(BrowserField browserField, 
		String appId, String appSecret,	String redirectUri, 
		String[] permissions, AuthenticationListener authListener) {
		super(appId, appSecret, redirectUri, permissions, authListener);
				if (browserField == null) {
			throw new IllegalArgumentException(
				"BrowserField must not be null.");
		}
				this.browserField = browserField;
		this.browserField.addListener(new BrowserFieldListenerAuth());
	}
	
	public BrowserFieldAuthDialogWrapper(BrowserField browserField) {
		this(browserField, null, null, null, null, null);
	}
	
	protected void loadUrl(String url) {
		browserField.requestContent(url);
	}
	
	protected void loadHTML(String htmlContent) {
		browserField.displayContent(htmlContent, redirectUri);
	}
	
	private class BrowserFieldListenerAuth extends BrowserFieldListener {
		
		public void documentLoaded(BrowserField browserField, Document document)
			throws Exception {
			trackCodeUrl(browserField.getDocumentUrl());
		}
	}
}