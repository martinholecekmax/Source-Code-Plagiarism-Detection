public class SendStanzaReceiver extends BroadcastReceiver {
    
    private final XmppTransportService service;
    
    public SendStanzaReceiver(XmppTransportService service) {
        this.service = service;
    }
    
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!intent.hasExtra("stanza")) {
            return;
        }
        Stanza stanza = intent.getParcelableExtra("stanza");
        service.send(stanza);
    }
}