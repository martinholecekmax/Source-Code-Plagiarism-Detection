public class CmsUpdateDBDropUnusedTables extends org.opencms.setup.db.update6to7.CmsUpdateDBDropUnusedTables {
    
    public CmsUpdateDBDropUnusedTables()
    throws IOException {
        super();
            }
    
    @Override
    protected String getPropertyFileLocation() {
        return CmsResource.getParentFolder(super.getPropertyFileLocation());
    }
}