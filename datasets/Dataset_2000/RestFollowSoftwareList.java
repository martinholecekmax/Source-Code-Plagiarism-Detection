@XmlRootElement(name = "followsoftwares")
public class RestFollowSoftwareList extends RestListBinder<RestFollowSoftware, FollowSoftware> {
    
    @SuppressWarnings("unused")
    private RestFollowSoftwareList() {
        super();
    }
    
    public RestFollowSoftwareList(final PageIterable<FollowSoftware> collection) {
        super(collection);
    }
    
    @XmlElement(name = "followsoftware")
    @XmlIDREF
    public List<RestFollowSoftware> getFollowSoftwares() {
        final List<RestFollowSoftware> followSoftwares = new ArrayList<RestFollowSoftware>();
        for (final RestFollowSoftware followSoftware : this) {
            followSoftwares.add(followSoftware);
        }
        return followSoftwares;
    }
}