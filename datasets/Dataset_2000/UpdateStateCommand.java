public abstract class UpdateStateCommand extends StateClusteringCommand {
    protected PropertyUpdater propertyUpdater = new PropertyUpdater();
    public boolean isPropertiesEmpty() {
        if (propertyUpdater.getProperties() == null) {
            propertyUpdater.setProperties(new HashMap());
            return true;
        }
        return propertyUpdater.getProperties().isEmpty();
    }
    public void addProperty(PropertyDifference diff) {
        if (propertyUpdater.getProperties() == null) {
            propertyUpdater.setProperties(new HashMap());
        }                                        
        propertyUpdater.addContextProperty(diff);
    }
}