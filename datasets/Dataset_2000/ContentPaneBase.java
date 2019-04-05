abstract class ContentPaneBase extends WidgetBase {
    
    @Property
    String tooltip;
    
        @Property(handler = HrefProperty.class)
    String href; 
    
    @Property
    String errorMessage;
    
    @Property
    String loadingMessage;
    
    @Property
    Boolean extractContent;
    
    @Property
    Boolean preLoad;
        
    @Property
    Boolean preventCache;
    
    @Property
    Boolean refreshOnShow;
        }