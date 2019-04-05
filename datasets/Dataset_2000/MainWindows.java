class MainWindows extends Composite {
	private static MainWindowsUiBinder uiBinder = GWT
			.create(MainWindowsUiBinder.class);
	@UiField RichTextArea richTextArea;
	@UiField HTML html;
	private final MarkDown2HtmlServiceAsync serv = GWT.create(MarkDown2HtmlService.class);
	interface MainWindowsUiBinder extends UiBinder<Widget, MainWindows> {
	}
	public MainWindows() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	 	@UiHandler("richTextArea")
	 	void onRichTextAreaKeyPress(KeyPressEvent event) {
	 		serv.markdown2html(richTextArea.getText() + event.getCharCode(), new AsyncCallback<String>() {
				@Override
				public void onSuccess(String arg0) {
					html.setHTML(arg0);	
				}
				@Override
				public void onFailure(Throwable arg0) {
					Window.alert("toto");
				}
			});
	 	}
}