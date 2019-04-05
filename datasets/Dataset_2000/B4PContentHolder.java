public final class B4PContentHolder {
    private static B4PContentHolder instance;
    private BPELServer bpelServer;
    private B4PContentHolder() {}
    public static B4PContentHolder getInstance() {
        if(instance == null) {
            instance = new B4PContentHolder();
        }
        return instance;
    }
    public BPELServer getBpelServer() {
        return bpelServer;
    }
    public void setBpelServer(BPELServer bpelServer) {
        this.bpelServer = bpelServer;
    }
}