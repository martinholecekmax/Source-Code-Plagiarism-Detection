public class KonakartAdminPanel extends PanelPluginBreadCrumbPanel {
    public KonakartAdminPanel(String id, IBreadCrumbModel breadCrumbModel, final String konakartUrl) {
        super(id, breadCrumbModel);
        add(new WebMarkupContainer("konakartAdmin") {
            
            @Override
            protected final void onComponentTag(final ComponentTag tag)
            {
                checkComponentTag(tag, "iframe");
                                tag.put("src", konakartUrl);
                super.onComponentTag(tag);
            }
        });
    }
    @Override
    public IModel<String> getTitle(Component component) {
        return new ResourceModel("konakart-admin-info-title");
    }
}