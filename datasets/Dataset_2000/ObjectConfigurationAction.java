public interface ObjectConfigurationAction {
    
    ObjectConfigurationAction to(Object... targets);
    
    ObjectConfigurationAction from(Object script);
    
    ObjectConfigurationAction plugin(Class<? extends Plugin> pluginClass);
    
    ObjectConfigurationAction plugin(String pluginId);
}