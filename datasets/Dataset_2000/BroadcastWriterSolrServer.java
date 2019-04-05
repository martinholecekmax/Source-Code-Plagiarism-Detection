public class BroadcastWriterSolrServer extends SolrServer {
	public BroadcastWriterSolrServer(SolrServerFactory solrServerFactory) {
		_solrServerFactory = solrServerFactory;
	}
	@Override
	public NamedList<Object> request(SolrRequest solrRequest)
		throws SolrServerException {
		NamedList<Object> response = null;
		if (!(solrRequest instanceof UpdateRequest)) {
			throw new IllegalStateException(
				"This SolrServer should be used only to update requests");
		}
		List<SolrServerWrapper> solrServerWrappers =
			_solrServerFactory.getLiveServers();
		for (SolrServerWrapper solrServerWrapper : solrServerWrappers) {
			try {
				response = solrServerWrapper.request(solrRequest);
			}
			catch (Exception e) {
				_log.error(
					"Could not send request to server " +
						solrServerWrapper.getId(),
					e);
			}
		}
		if (response == null) {
			throw new SolrServerException("No server available");
		}
		return response;
	}
	private static Log _log = LogFactoryUtil.getLog(
		BroadcastWriterSolrServer.class);
	private SolrServerFactory _solrServerFactory;
}