public class WSDLGrammarReaderController implements
		GrammarReaderController2, LSResourceResolver {
	private GrammarReaderController2 nextController;
	private Map<String, EmbeddedSchema> schemas;
	private String baseURI;
	
	public WSDLGrammarReaderController(GrammarReaderController2 nextController,
									   String baseURI, Map<String, EmbeddedSchema> sources) {
		this.nextController = nextController;
		this.baseURI = baseURI;
		this.schemas = sources;
	}
	public void error(Locator[] locs, String msg, Exception nestedException) {
		if (nextController != null) {
			nextController.error(locs, msg, nestedException);
		}
	}
	public void warning(Locator[] locs, String errorMessage) {
		if (nextController != null) {
			nextController.warning(locs, errorMessage);
		}
	}
	public InputSource resolveEntity(String publicId, String systemId) {
		return null;
	}
	public LSResourceResolver getLSResourceResolver() {
		return this;
	}
	public LSInput resolveResource(String type, String namespaceURI,
			String publicId, String systemId, String baseURI) {
		EmbeddedSchema schema = schemas.get(namespaceURI);
		if (schema != null) {
			return new DOMLSInputImpl(this.baseURI, schema.getSystemId(), 
					schema.getSchemaElement());
		} else {
			return null;
		}
	}
}