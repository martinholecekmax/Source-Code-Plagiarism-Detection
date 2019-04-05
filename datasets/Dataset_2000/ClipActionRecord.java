public class ClipActionRecord {
    private ClipEventFlags eventFlags;
    private long actionRecordSize;
    private int keyCode;
    private Vector<Action> actions;
    
    public ClipActionRecord(SWFInputStream swf) throws IOException {
        eventFlags = new ClipEventFlags(swf);
        if (eventFlags.isEndFlag())
            return;
        actionRecordSize = swf.readUnsignedInt();
                swf.pushBuffer((int) (actionRecordSize - 4));
        if (eventFlags.isKeyPress())
            keyCode = swf.readUnsignedByte();
        while (swf.getLength() > 0) {
            actions.add(swf.readAction());
        }
        byte[] rest = swf.popBuffer();
        if (rest != null) {
            System.err.println("Corrupted ClipActionRecord, " + rest.length
                    + " bytes leftoever.");
        }
    }
    public void write(SWFOutputStream swf) throws IOException {
        eventFlags.write(swf);
                swf.writeUnsignedInt(actionRecordSize);
        if (eventFlags.isKeyPress())
            swf.writeUnsignedByte(keyCode);
        for (int i = 0; i < actions.size(); i++) {
            SWFAction a = (SWFAction) actions.get(i);
            swf.writeAction(a);
        }
    }
    public boolean isEndRecord() {
        return eventFlags.isEndFlag();
    }
    public String toString() {
        return "ClipActionRecord " + actions.size();
    }
}