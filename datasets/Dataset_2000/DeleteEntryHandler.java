public class DeleteEntryHandler extends BaseKeystoreHandler {
    public DeleteEntryHandler() {
        super(DELETE_ENTRY, "/WEB-INF/view/keystore/viewKeystore.jsp");
    }
    public String actionBeforeView(ActionRequest request, ActionResponse response, MultiPageModel model) throws PortletException, IOException {
        String id = request.getParameter("id");
        String alias = request.getParameter("alias");
        if(id != null) {
            response.setRenderParameter("id", id);
            if(alias != null) {
            	KeystoreData data = (KeystoreData) request.getPortletSession(true).getAttribute(KEYSTORE_DATA_PREFIX + id);
            	try {
                    data.deleteEntry(alias);
                } catch (KeystoreException e) {
                    throw new PortletException(e);
                }
            }
        }         return getMode();
    }
    public void renderView(RenderRequest request, RenderResponse response, MultiPageModel model) throws PortletException, IOException {
        String id = request.getParameter("id");
        request.setAttribute("id", id);
        request.setAttribute("keystore", request.getPortletSession(true).getAttribute(KEYSTORE_DATA_PREFIX + id));
    }
    public String actionAfterView(ActionRequest request, ActionResponse response, MultiPageModel model) throws PortletException, IOException {
    	String id = request.getParameter("id");
    	response.setRenderParameter("id", id);
        return VIEW_KEYSTORE+BEFORE_ACTION;
    }
}