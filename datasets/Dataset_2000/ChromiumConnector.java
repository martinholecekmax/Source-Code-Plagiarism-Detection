public class ChromiumConnector {
  public static final String LOCALHOST_ADDRESS = "127.0.0.1";
  
  public static List<ChromiumTabInfo> getAvailableTabs(int port) throws IOException {
    return getAvailableTabs(null, port);
  }
  
  public static List<ChromiumTabInfo> getAvailableTabs(String host, int port) throws IOException {
    if (host == null) {
      host = LOCALHOST_ADDRESS;
    }
    URL chromiumUrl = new URL("http", host, port, "/json");
    URLConnection connection = chromiumUrl.openConnection();
    String text = readText(connection, connection.getInputStream());
    try {
      JSONArray arr = new JSONArray(text);
      List<ChromiumTabInfo> tabs = new ArrayList<ChromiumTabInfo>();
      for (int i = 0; i < arr.length(); i++) {
        JSONObject object = arr.getJSONObject(i);
        ChromiumTabInfo tab = ChromiumTabInfo.fromJson(object);
        tab.patchUpUrl(host, port);
        tabs.add(tab);
      }
      Collections.sort(tabs, ChromiumTabInfo.getComparator());
      return tabs;
    } catch (JSONException exception) {
      throw new IOException(exception);
    }
  }
  
  public static String getWebSocketURLFor(int port, int tab) {
    return getWebSocketURLFor(null, port, tab);
  }
  
  public static String getWebSocketURLFor(String host, int port, int tab) {
    if (host == null) {
      host = LOCALHOST_ADDRESS;
    }
    return "ws:  }
  private static String readText(URLConnection connection, InputStream in) throws IOException {
        Reader reader = new InputStreamReader(in, "UTF-8");
    StringBuilder builder = new StringBuilder();
    char[] buffer = new char[1024];
    int count = reader.read(buffer);
    while (count != -1) {
      builder.append(buffer, 0, count);
      count = reader.read(buffer);
    }
    return builder.toString();
  }
  private ChromiumConnector() {
  }
}