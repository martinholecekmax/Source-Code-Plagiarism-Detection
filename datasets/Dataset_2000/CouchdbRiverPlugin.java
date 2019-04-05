public class CouchdbRiverPlugin extends AbstractPlugin {
    @Inject
    public CouchdbRiverPlugin() {
    }
    @Override
    public String name() {
        return "river-couchdb";
    }
    @Override
    public String description() {
        return "River CouchDB Plugin";
    }
    public void onModule(RiversModule module) {
        module.registerRiver("couchdb", CouchdbRiverModule.class);
    }
}