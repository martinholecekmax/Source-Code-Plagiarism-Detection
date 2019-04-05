public interface StartDocument extends XMLEvent {
  
  public String getSystemId();
  
  public String getCharacterEncodingScheme();
  
  public boolean encodingSet();
  
  public boolean isStandalone();
  
  public boolean standaloneSet();
  
  public String getVersion();
}