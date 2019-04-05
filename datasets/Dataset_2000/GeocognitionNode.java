@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "geocognitionNode", "nodeContent" })
@XmlRootElement(name = "geocognition-node")
public class GeocognitionNode {
	@XmlElement(name = "geocognition-node", required = true)
	protected List<GeocognitionNode> geocognitionNode;
	@XmlElement(name = "node-content", required = true)
	protected NodeContent nodeContent;
	@XmlAttribute(required = true)
	protected String id;
	@XmlAttribute
	protected Integer version;
	
	public List<GeocognitionNode> getGeocognitionNode() {
		if (geocognitionNode == null) {
			geocognitionNode = new ArrayList<GeocognitionNode>();
		}
		return this.geocognitionNode;
	}
	
	public NodeContent getNodeContent() {
		return nodeContent;
	}
	
	public void setNodeContent(NodeContent value) {
		this.nodeContent = value;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String value) {
		this.id = value;
	}
	
	public Integer getVersion() {
		return version;
	}
	
	public void setVersion(Integer value) {
		this.version = value;
	}
}