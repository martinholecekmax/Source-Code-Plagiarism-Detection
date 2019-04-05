public final class ClientList extends WrapperList<Client> {
    
    private volatile Context context;
    
    public ClientList(Context context) {
        super(new CopyOnWriteArrayList<Client>());
        this.context = context;
    }
    @Override
    public boolean add(Client client) {
                if (client.getContext() == null) {
            client.setContext(getContext().createChildContext());
        }
        return super.add(client);
    }
    
    public Client add(Protocol protocol) {
        final Client result = new Client(protocol);
        result.setContext(getContext().createChildContext());
        add(result);
        return result;
    }
    
    public Context getContext() {
        return this.context;
    }
    
    public void setContext(Context context) {
        this.context = context;
    }
}