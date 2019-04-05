public class FennecTabsServerSyncStage extends ServerSyncStage {
  private static final String COLLECTION = "tabs";
  public FennecTabsServerSyncStage(GlobalSession session) {
    super(session);
  }
  public class FennecTabsRecordFactory extends RecordFactory {
    @Override
    public Record createRecord(Record record) {
      TabsRecord r = new TabsRecord();
      r.initFromEnvelope((CryptoRecord) record);
      return r;
    }
  }
  @Override
  protected String getCollection() {
    return COLLECTION;
  }
  @Override
  protected String getEngineName() {
    return COLLECTION;
  }
  @Override
  public Integer getStorageVersion() {
    return VersionConstants.TABS_ENGINE_VERSION;
  }
  @Override
  protected Repository getLocalRepository() {
    final ClientsDataDelegate clientsDelegate = session.getClientsDelegate();
    return new FennecTabsRepository(clientsDelegate.getClientName(), clientsDelegate.getAccountGUID());
  }
  @Override
  protected RecordFactory getRecordFactory() {
    return new FennecTabsRecordFactory();
  }
}