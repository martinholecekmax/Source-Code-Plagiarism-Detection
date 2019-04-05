public class BibTeXMLFile {
	public final static String BIBTEXML_NAMESPACE = "http:	private Node root;
	private XPathContext context;
	public BibTeXMLFile(Node root) {
		this.root = root;
		context = new XPathContext("bibtex", BIBTEXML_NAMESPACE);
		context.addNamespace("b", BIBTEXML_NAMESPACE);		
	}
	
	public Iterator<BibTeXMLEntry> getEntries() {
		List<BibTeXMLEntry> entries = new ArrayList<BibTeXMLEntry>();
		Nodes results = root.query("		for (int i=0; i<results.size(); i++) {
			entries.add(new BibTeXMLEntry(results.get(i)));
		}
		return entries.iterator();
	}
	public BibTeXMLEntry getEntry(String id) {
		Nodes results = root.query("		if (results.size() > 0) {
			return new BibTeXMLEntry(results.get(0));
		}
		return null;
	}
}