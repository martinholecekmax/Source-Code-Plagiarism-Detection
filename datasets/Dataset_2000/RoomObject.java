public class RoomObject extends NexusObject
    implements Keyed
{
    
    public static class ChatEvent implements Streamable {
        
        public final String nickname;
        
        public final String message;
        public ChatEvent (String nickname, String message) {
            this.nickname = nickname;
            this.message = message;
        }
    }
    
    public final String name;
    
    public final DService<RoomService> roomSvc;
    
    public final DSignal<ChatEvent> chatEvent = DSignal.create();
        public Comparable<?> getKey () {
        return name;
    }
    public RoomObject (String name, DService<RoomService> roomSvc) {
        this.name = name;
        this.roomSvc = roomSvc;
    }
    @Override
    protected DAttribute getAttribute (int index) {
        switch (index) {
        case 0: return roomSvc;
        case 1: return chatEvent;
        default: throw new IndexOutOfBoundsException("Invalid attribute index " + index);
        }
    }
    @Override
    protected int getAttributeCount () {
        return 2;
    }
}