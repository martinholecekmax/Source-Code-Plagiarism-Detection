public class StaticDriver extends Driver {
	private final Map<String, StringOutput> resources = new HashMap<String, StringOutput>();
	public StaticDriver(String name, Properties props) {
		super(name, props);
		DriverFactory.put(name, this);		
	}
	
	public void addResource(String relUrl, String content) throws IOException {
		this.addResource(relUrl, content,"ISO-8859-1");
	}
	
	public void addResource(String relUrl, String content, String charset) throws IOException {
		StringOutput stringOutput = new StringOutput();
		stringOutput.setStatusCode(200);
		stringOutput.setStatusMessage("OK");
		stringOutput.setCharsetName(charset);
		stringOutput.open();
		stringOutput.write(content);
		resources.put(relUrl, stringOutput);
	}
	@Override
	protected StringOutput getResourceAsString(ResourceContext target)
			throws HttpErrorPage {
		StringOutput result = resources.get(target.getRelUrl());
		if (result == null)
			throw new HttpErrorPage(404, "Not found" + "The page: "
					+ target.getRelUrl() + " does not exist", "The page: "
					+ target.getRelUrl() + " does not exist");
		return result;
	}
}