public interface SystemVersion {
  
  public String getName();
  
  public void setName(String name);
  
  public String getVendor();
  
  public void setVendor(String vendor);
  
  public String getVersion();
  
  public void setVersion(String version);
  
  public int getMajorVersion();
  
  public void setMajorVersion(int majorVersion);
  
  public int getMinorVersion();
  
  public void setMinorVersion(int minorVersion);
}