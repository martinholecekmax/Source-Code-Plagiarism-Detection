public class BasicDataStoreBusProtocolHandler implements StoreBusProtocolHandler {
    protected final StoreBus<byte[], byte[]> _storeBus;
    public BasicDataStoreBusProtocolHandler(StoreBus<byte[], byte[]> storeBus) {
        this._storeBus = storeBus;
    }
    @Override
    public byte[] get(byte[] key) throws Exception {
        return _storeBus.get(key);
    }
    @Override
    public Position getPosition() {
        return _storeBus.getPosition();
    }
    @Override
    public Position getPosition(Clock clock) {
        return _storeBus.getPosition(clock);
    }
    @Override
    public Position getPosition(String positionStr) {
        return SimplePosition.parsePosition(positionStr);
    }
    @Override
    public String meta(String opt, String key, String value) throws Exception {
        StoreBusDirective directive = StoreBusDirective.valueOf(opt);
        if(directive == StoreBusDirective.Position) {
            if(key == null) {
                return getPosition().toString();
            } else {
                Clock clock = Clock.parseClock(key);
                return getPosition(clock).toString();
            }
        }
                return ProtocolConstants.NOP;
    }
    @Override
    public Position syncUp(Position position, Map<byte[], Event<byte[]>> map) {
        return _storeBus.get(position, map);    
    }
}