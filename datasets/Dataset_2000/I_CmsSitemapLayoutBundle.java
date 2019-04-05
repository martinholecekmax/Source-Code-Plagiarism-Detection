public interface I_CmsSitemapLayoutBundle extends org.opencms.gwt.client.ui.css.I_CmsLayoutBundle {
    
    interface I_CmsClipboardCss extends CssResource {
        
        String clipboardList();
        
        String listClearButton();
        
        String menuTabContainer();
    }
    
    interface I_CmsSitemapCss extends CssResource {
        
        String page();
        
        String pageCenter();
        
        String root();
    }
    
    I_CmsSitemapLayoutBundle INSTANCE = GWT.create(I_CmsSitemapLayoutBundle.class);
    
    org.opencms.gwt.client.ui.css.I_CmsImageBundle baseImages();
    
    @Source("clipboard.css")
    I_CmsClipboardCss clipboardCss();
    
    I_CmsImageBundle images();
    
    @Source("sitemap.css")
    I_CmsSitemapCss sitemapCss();
    
    @Source("sitemapItem.css")
    I_CmsSitemapItemCss sitemapItemCss();
}