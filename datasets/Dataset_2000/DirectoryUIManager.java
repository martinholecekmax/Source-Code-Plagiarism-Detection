public interface DirectoryUIManager extends Serializable {
    
    DirectoryUI getDirectoryInfo(String directoryName) throws ClientException;
    
    List<String> getDirectoryNames() throws ClientException;
}