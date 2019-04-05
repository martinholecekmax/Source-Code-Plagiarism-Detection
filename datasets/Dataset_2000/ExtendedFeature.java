public interface ExtendedFeature extends TypeTools {
	
	public void setExtensionName(String extension);
	
	public String getExtensionName();
	
	public void setExtensionData(String extensionData);
	
	public String getExtensionData();
	
	public void clearExtension();
	
	public boolean hasExtension();
	
	public ExtendedFeature clone();
}