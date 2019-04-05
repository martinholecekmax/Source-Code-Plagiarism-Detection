public interface ClojureComponentImplementationModel extends ComponentImplementationModel {
    
    public static final String DEFAULT_NAMESPACE = "urn:switchyard-component-clojure:config:1.0";
    
    String CLOJURE = "clojure";
    
    String SCRIPT = "script";
    
    String SCRIPT_FILE = "scriptFile";
    
    String INJECT_EXCHANGE = "injectExchange";
    
    ClojureScriptModel getScriptModel();
    
    ClojureComponentImplementationModel setScriptModel(final ClojureScriptModel scriptModel);
    
    String getScriptFile();
    
    ClojureComponentImplementationModel setScriptFile(final String scriptFile);
    
    Boolean injectExchange();
    
    ClojureComponentImplementationModel setInjectExchange(final Boolean enable);
}