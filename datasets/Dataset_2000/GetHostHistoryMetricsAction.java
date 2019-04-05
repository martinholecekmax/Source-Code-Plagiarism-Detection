public class GetHostHistoryMetricsAction extends MonitorAction {
  @Override
  protected String doAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
    try {
      String hostName = request.getParameter("hostName");
      String groupName = request.getParameter("groupName");
      String itemNames = request.getParameter("items");
      String startTime = request.getParameter("startTime");
      String endTime = request.getParameter("endTime");
      if(hostName == null) {
        throw new IOException("No hostName parameter");
      }
      if(itemNames == null || itemNames.length() == 0) {
        List<HostHistoryMetrics> records = MonitorManagerServer.getMonitorService().getHostHistoryMetrics(hostName, groupName, startTime, endTime);
        return JsonUtil.listToJson(records);
      } else {
        List<String> itemNameList = new ArrayList<String>();
        if(itemNames != null) {
          String[] itemNameTokens = itemNames.split(",");
          for(String eachItem: itemNameTokens) {
            itemNameList.add(eachItem);
          }
        }
        List<HostHistoryMetrics> records = MonitorManagerServer.getMonitorService().getHostHistoryItemMetrics(hostName, groupName, itemNameList, startTime, endTime);
        return JsonUtil.listToJson(records);
      }
    } catch (TException e) {
      throw new IOException(e.getMessage(), e);
    } 
  }
}