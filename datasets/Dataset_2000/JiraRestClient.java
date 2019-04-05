public interface JiraRestClient {
	
    IssueRestClient getIssueClient();
	
    SessionRestClient getSessionClient();
	
	UserRestClient getUserClient();
	
	ProjectRestClient getProjectClient();
	
	ComponentRestClient getComponentClient();
	
	MetadataRestClient getMetadataClient();
	
	SearchRestClient getSearchClient();
	
	VersionRestClient getVersionRestClient();
}