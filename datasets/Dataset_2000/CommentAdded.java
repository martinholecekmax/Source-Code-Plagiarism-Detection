public class CommentAdded extends ChangeBasedEvent implements GerritJsonEvent {
    private List<Approval> approvals = new ArrayList<Approval>();
    @Override
    public GerritEventType getEventType() {
        return GerritEventType.COMMENT_ADDED;
    }
    
    public List<Approval> getApprovals() {
        return approvals;
    }
    
    public void setApprovals(List<Approval> approvals) {
        this.approvals = approvals;
    }
    @Override
    public boolean isScorable() {
        return true;
    }
    @Override
    public void fromJson(JSONObject json) {
        super.fromJson(json);
        if (json.containsKey(AUTHOR)) {
            account = new Account(json.getJSONObject(AUTHOR));
        }
        if (json.containsKey(APPROVALS)) {
            JSONArray eventApprovals = json.getJSONArray(APPROVALS);
            for (int i = 0; i < eventApprovals.size(); i++) {
                approvals.add(new Approval(eventApprovals.getJSONObject(i)));
            }
        }
    }
}