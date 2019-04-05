public interface RequestQueryParameters {
    String getParameter(String name);
    Map<String, String[]> getParameterMap();
    Enumeration<String> getParameterNames();
    String[] getParameterValues(String name);
    String getQueryString();
    void setQueryString(String query);
}