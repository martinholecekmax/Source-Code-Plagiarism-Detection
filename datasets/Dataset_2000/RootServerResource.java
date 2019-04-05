public class RootServerResource extends WadlServerResource implements
		RootResource {
	@Override
	protected RepresentationInfo describe(MethodInfo methodInfo,
			Class<?> representationClass, Variant variant) {
		RepresentationInfo result = new RepresentationInfo(MediaType.TEXT_PLAIN);
		result.setIdentifier("root");
		DocumentationInfo doc = new DocumentationInfo();
		doc.setTitle("Mail application");
		doc.setTextContent("Simple string welcoming the user to the mail application");
		result.getDocumentations().add(doc);
		return result;
	}
	@Override
	protected void doInit() throws ResourceException {
		setAutoDescribing(false);
		setName("Root resource");
		setDescription("The root resource of the mail server application");
	}
	public String represent() {
		return "Welcome to the " + getApplication().getName() + " !";
	}
}