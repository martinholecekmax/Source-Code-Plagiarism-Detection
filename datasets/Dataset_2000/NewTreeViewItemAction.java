public class NewTreeViewItemAction extends CollectionElementViewBaseAction {
	private static Log log = LogFactory.getLog(NewTreeViewItemAction.class);
	@SuppressWarnings("rawtypes")
	public void execute() throws Exception {
		String fullPath = null;
		if (getCollectionElementView().isRepresentsAggregate()) {
			getCollectionElementView().reset();				
		}
		Map[] keyValues = getCollectionElementView().getCollectionTab().getSelectedKeys();
				if (keyValues.length > 0) {
			Map keyValue = keyValues[keyValues.length - 1];
			Object treeNode = MapFacade.findEntity(getCollectionElementView().getCollectionTab().getModelName(), keyValue);
			TreeViewParser treeViewParser = (TreeViewParser) getContext().get(getRequest(), TreeViewParser.XAVA_TREE_VIEW_PARSER);
			TreeView metaTreeView = treeViewParser.getMetaTreeView(getCollectionElementView().getCollectionTab().getModelName());
			if (metaTreeView != null){
				try {
					fullPath = metaTreeView.getNodeFullPath(treeNode);
				} catch (Exception ex) {
					log.debug(ex);
				}
			}
		}
		getContext().put(getRequest(), TreeViewParser.XAVA_TREE_VIEW_NODE_FULL_PATH, fullPath);
		getCollectionElementView().setCollectionDetailVisible(true);
		getCollectionElementView().setCollectionEditingRow(-1);
		showDialog(getCollectionElementView());		
		if (getCollectionElementView().isCollectionEditable() || 
			getCollectionElementView().isCollectionMembersEditables()) 
		{ 
			addActions(getCollectionElementView().getSaveCollectionElementAction());
		} 		
		Iterator itDetailActions = getCollectionElementView().getActionsNamesDetail().iterator();		
		while (itDetailActions.hasNext()) {			
			addActions(itDetailActions.next().toString());			
		}
		addActions(getCollectionElementView().getHideCollectionElementAction());
	}
}