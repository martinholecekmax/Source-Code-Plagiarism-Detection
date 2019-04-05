public interface FileContentManager {
    
    public FileContent getFileContent(Weblog weblog, String fileId)
            throws FileNotFoundException, FilePathException;
    
    public void saveFileContent(Weblog weblog,
            String fileId,
            InputStream is)
            throws FileNotFoundException, FilePathException, FileIOException;
    
    public void deleteFile(Weblog weblog, String fileId)
            throws FileNotFoundException, FilePathException, FileIOException;
    
    public void deleteAllFiles(Weblog weblog)
            throws FileIOException;
    
    public boolean overQuota(Weblog weblog);
    
    public boolean canSave(Weblog weblog,
            String fileName,
            String contentType,
            long size,
            RollerMessages messages);
    
    public void release();
}