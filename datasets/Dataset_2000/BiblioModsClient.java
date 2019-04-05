public class BiblioModsClient
        implements IsSerializable {
    
    private ModsCollectionClient modsCollection;
    
    private ModsTypeClient mods;
    
    public ModsCollectionClient getModsCollection() {
        return modsCollection;
    }
    
    public void setModsCollection(ModsCollectionClient modsCollection) {
        this.modsCollection = modsCollection;
    }
    
    public ModsTypeClient getMods() {
        return mods;
    }
    
    public void setMods(ModsTypeClient mods) {
        this.mods = mods;
    }
}