interface InitConfig {
  String getInitParameter(String parameter);
  String getContextParameter(String paramater);
  String getInitOrContextParameter(String parameter);
  ServletContext getServletContext();
}