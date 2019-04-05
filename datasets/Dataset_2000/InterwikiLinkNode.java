public abstract class InterwikiLinkNode extends LinkNode {
	public InterwikiLinkNode() {
	}
	public InterwikiLinkNode(int token) {
		super(token);
	}
	public InterwikiLinkNode(int token, String uri, String wikiName) {
		this(token);
		_uri = uri;
		_wikiName = wikiName;
	}
	public InterwikiLinkNode(String wikiname) {
		_wikiName = wikiname;
	}
	public InterwikiLinkNode(String uri, String wikiname) {
		_uri = uri;
		_wikiName = wikiname;
	}
	public String getUri() {
		return _uri;
	}
	public String getWikiName() {
		return _wikiName;
	}
	public void setUri(String uri) {
		_uri = uri;
	}
	private String _uri;
	private String _wikiName;
}