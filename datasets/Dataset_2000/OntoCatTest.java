public class OntoCatTest {
	public static void main(String[] args) throws OntologyServiceException {
												OntologyService os = new BioportalOntologyService();
		List<Ontology> results = os.getOntologies();
		JSONArray outer = new JSONArray();
				for (Ontology o : results) {
			JSONObject inner = new JSONObject();
												String acc = o.getOntologyAccession();
			String label = o.getLabel();
						inner.put("value", acc);
			inner.put("label", label);
			outer.add(inner);
		}
		String jsonString = outer.toJSONString();
		System.out.println(jsonString);
																		for (OntologyTerm ot : os.searchAll("adipocyte",
				SearchOptions.INCLUDE_PROPERTIES)) {
					}
	}
	class Data {
		private String title;
		private Long id;
		private Boolean children;
		private List<Data> groups;
		public String getTitle() {
			return title;
		}
		public Long getId() {
			return id;
		}
		public Boolean getChildren() {
			return children;
		}
		public List<Data> getGroups() {
			return groups;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public void setChildren(Boolean children) {
			this.children = children;
		}
		public void setGroups(List<Data> groups) {
			this.groups = groups;
		}
		public String toString() {
			return String.format("title:%s,id:%d,children:%s,groups:%s", title,
					id, children, groups);
		}
	}
}