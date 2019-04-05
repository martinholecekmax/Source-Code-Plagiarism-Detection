public class CollaboratorListLoader extends BaseLoader {
    private String mRepoOwner;
    private String mRepoName;
    public CollaboratorListLoader(Context context, String repoOwner, String repoName) {
        super(context);
        mRepoOwner = repoOwner;
        mRepoName = repoName;
    }
    @Override
    public void doLoadInBackground(HashMap<Integer, Object> result) throws IOException {
        Gh4Application app = (Gh4Application) getContext().getApplicationContext();
        GitHubClient client = new GitHubClient();
        client.setOAuth2Token(app.getAuthToken());
        CollaboratorService collabService = new CollaboratorService(client);
        result.put(LoaderResult.DATA, collabService.getCollaborators(new RepositoryId(mRepoOwner, mRepoName)));
    }
}