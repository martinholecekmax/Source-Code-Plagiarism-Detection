public interface IStreamableFileService {
	
	public void setPrefix(String prefix);
	
    public String getPrefix();
    
    public void setExtension(String extension);
	
    public String getExtension();
    
    public String prepareFilename(String name);
    
    public boolean canHandle(File file);
    
    public IStreamableFile getStreamableFile(File file) throws IOException;
}