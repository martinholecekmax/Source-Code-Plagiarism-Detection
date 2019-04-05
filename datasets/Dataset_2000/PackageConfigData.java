public class PackageConfigData
    implements
    IsSerializable {
	public PackageConfigData() {}
	public PackageConfigData(String name) {
		this.name = name;
	}
    public String uuid;
    public String header;
    public String externalURI;
    public String name;
    public String description;
    public Date   lastModified;
    public String lasContributor;
    public String state;
    public boolean archived = false;
    public boolean isSnapshot = false;
    public String snapshotName;
    public Date dateCreated;
    public String checkinComment;
    public HashMap<String,String> catRules;
}