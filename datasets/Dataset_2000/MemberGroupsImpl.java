public class MemberGroupsImpl
        extends BaseSchemaEntity
        implements MemberGroups {
    private final static long serialVersionUID = 2461660169443089969L;
    protected List<MemberGroup> memberGroupList;
    protected Long total;
    public List<MemberGroup> getMemberGroupList() {
        if (memberGroupList == null) {
            memberGroupList = new ArrayList<MemberGroup>();
        }
        return this.memberGroupList;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long value) {
        this.total = value;
    }
    @Override
    public void init(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, null, null);
        setTotal(XppUtils.getAttributeValueAsLongFromNode(parser, "total"));
        while (parser.nextTag() == XmlPullParser.START_TAG) {
            String name = parser.getName();
            if (name.equals("member-group")) {
                MemberGroupImpl memberGroupImpl = new MemberGroupImpl();
                memberGroupImpl.init(parser);
                getMemberGroupList().add(memberGroupImpl);
            } else {
                                LOG.warning("Found tag that we don't recognize: " + name);
                XppUtils.skipSubTree(parser);
            }
        }
    }
    @Override
    public void toXml(XmlSerializer serializer) throws IOException {
        XmlSerializer element = serializer.startTag(null, "member-groups");
        XppUtils.setAttributeValueToNode(element, "total", getTotal());
        for (MemberGroup memberGroup : getMemberGroupList()) {
            ((MemberGroupImpl) memberGroup).toXml(serializer);
        }
        serializer.endTag(null, "member-groups");
    }
}