public class RepositoryReviewRequestQuery extends StatusReviewRequestQuery {
    private int repositoryId;
    private int changeNum;
    public RepositoryReviewRequestQuery(ReviewRequestStatus status, int repositoryId, int changeNum) {
        super(status);
        this.repositoryId = repositoryId;
        this.changeNum = changeNum;
    }
    @Override
    public String getQuery() {
        return String.format("repository/%s/changenum/%s%s", repositoryId, changeNum, super.getQuery());
    }
    public boolean isValid() {
        return (changeNum > 0);
    }
}