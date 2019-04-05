public interface StatisticsViewStrategy {
    
    public Map<String, Map<String, InOutStatisticsView>> determineView(
            List<StatisticsRecord> statisticsRecords,
            ComponentType type);
    
    public Map<String, InOutStatisticsView> determineView(String id,
                                                          List<StatisticsRecord> statisticsRecords,
                                                          ComponentType type);
}