@Name("multiNavTreeManager")
@Scope(CONVERSATION)
public class CMMultiNavTreeManager extends MultiNavTreeManager {
    private static final long serialVersionUID = 1L;
    @In(create = true)
    protected NuxeoPrincipal currentUser;
    protected List<NavTreeDescriptor> personnalNavTree;
    protected List<NavTreeDescriptor> outsideNavTree;
    protected List<NavTreeDescriptor> currentNavTree;
    @Create
    public void create() {
        outsideNavTree = getNavTree(currentUser.isAdministrator());
        personnalNavTree = getNavTree(true);
        setSelectedNavigationTree((currentUser.isAdministrator()) ? STD_NAV_TREE
                : "MAILBOXES_FOLDER");
        currentNavTree = outsideNavTree;
    }
    protected List<NavTreeDescriptor> getNavTree(boolean includeStdNav) {
        List<NavTreeDescriptor> result = new ArrayList<NavTreeDescriptor>();
        if (includeStdNav) {
            result.add(new NavTreeDescriptor(STD_NAV_TREE, STD_NAV_TREE_LABEL));
        }
        NavTreeService navTreeService = Framework.getLocalService(NavTreeService.class);
        result.addAll(navTreeService.getTreeDescriptors());
        return result;
    }
    @Override
    public List<NavTreeDescriptor> getAvailableNavigationTrees() {
        return currentNavTree;
    }
    @Observer(EventNames.GO_PERSONAL_WORKSPACE)
    public void switchToPersonnal() {
        currentNavTree = personnalNavTree;
        setSelectedNavigationTree(STD_NAV_TREE);
    }
    @Observer(EventNames.GO_HOME)
    public void switchToOutside() {
        currentNavTree = outsideNavTree;
        setSelectedNavigationTree((currentUser.isAdministrator()) ? STD_NAV_TREE
                : "MAILBOXES_FOLDER");
    }
}