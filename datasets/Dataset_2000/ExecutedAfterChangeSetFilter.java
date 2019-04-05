public class ExecutedAfterChangeSetFilter implements ChangeSetFilter {
    private Set<String> changeLogsAfterDate = new HashSet<String>();
    public ExecutedAfterChangeSetFilter(Date date, List<RanChangeSet> ranChangeSets) {
        for (RanChangeSet ranChangeSet : ranChangeSets) {
            if (ranChangeSet.getDateExecuted() != null && ranChangeSet.getDateExecuted().getTime() > date.getTime()) {
                changeLogsAfterDate.add(changeLogToString(ranChangeSet.getId(), ranChangeSet.getAuthor(), ranChangeSet.getChangeLog()));
            }
        }
    }
    private String changeLogToString(String id, String author, String changeLog) {
        return id+":"+author+":"+changeLog;
    }
    public boolean accepts(ChangeSet changeSet) {
        return changeLogsAfterDate.contains(changeLogToString(changeSet.getId(), changeSet.getAuthor(), changeSet.getFilePath()));
    }
}