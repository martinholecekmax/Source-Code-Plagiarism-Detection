public class RTL8139RxRing implements RTL8139Constants {
    private static final int UPD_SIZE = 16;
        
    private final int nrFrames;
    
    private final byte[] data;
    
    private final MemoryResource mem;
    
    private final int firstUPDOffset;
    
    private final Address firstUPDAddress;
    private int index;
    
    public RTL8139RxRing(int nrFrames, ResourceManager rm) {
                final int size = TOTAL_RX_BUF_SIZE;
        this.data = new byte[size];
        this.nrFrames = nrFrames;
        this.mem = rm.asMemoryResource(data);
        final Address memAddr = mem.getAddress();
        int offset = 0;
        this.firstUPDOffset = offset;
        this.firstUPDAddress = memAddr.add(firstUPDOffset);
    }
    
    public void initialize() {
        index = 0;
    }
    
    public int getPktStatus() {
        final int updOffset = firstUPDOffset + index;
        return mem.getInt(updOffset);
    }
    
    public void setPktStatus(int index, int value) {
        final int updOffset = firstUPDOffset + (index * UPD_SIZE) - 4;
        mem.setInt(updOffset + 4, value);
        this.index = index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }
    
    public SocketBuffer getPacket(int _length) {
        final int updOffset = firstUPDOffset + index;
        final SocketBuffer skbuf = new SocketBuffer();
        if (_length > 0) {
            skbuf.append(data, updOffset + 4, _length - 4);
        }
        index = (index + _length + 4 + 3) & ~3;
        index &= (RX_BUF_SIZE - 1);
        return skbuf;
    }
    
    public Address getFirstUPDAddress() {
        return firstUPDAddress;
    }
    
    public int getNrFrames() {
        return nrFrames;
    }
}