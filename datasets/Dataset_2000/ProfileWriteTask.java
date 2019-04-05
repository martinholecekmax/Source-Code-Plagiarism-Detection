public class ProfileWriteTask extends Task
{
    protected String fileName;
    private String osAlias;
    private String userProfileAlias;
    
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setOSAlias(String osAlias) {
        this.osAlias = osAlias;
    }
    
    public void setUserProfileAlias(String userProfileAlias) {
        this.userProfileAlias = userProfileAlias;
    }
    
    public void execute() {
        if (fileName == null) {
            throw new BuildException("fileName parameter not set");
        }
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
        } catch (IOException e) {
            throw new BuildException("failed to open output file: " + fileName, e);
        }
        try {
            ObjectStore os = ObjectStoreFactory.getObjectStore(osAlias);
            ObjectStoreWriter userProfileOS =
                ObjectStoreWriterFactory.getObjectStoreWriter(userProfileAlias);
            ProfileManager pm = new ProfileManager(os, userProfileOS);
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(fw);
            ProfileManagerBinding.marshal(pm, writer);
        } catch (Exception e) {
            throw new BuildException(e);
        } finally {
            Thread.currentThread().setContextClassLoader(cl);
            try {
                fw.close();
            } catch (IOException e) {
                throw new BuildException("failed to close output file: " + fileName, e);
            }
        }
    }
}