public class SharedObjectMsgEvent extends RemoteSharedObjectEvent {
	private static final long serialVersionUID = -8674874265514762123L;
	
	public SharedObjectMsgEvent(ID senderObj, ID remoteCont, SharedObjectMsg msg) {
		super(senderObj, remoteCont, msg);
	}
	public SharedObjectMsg getSharedObjectMsg() {
		return (SharedObjectMsg) super.getData();
	}
	public String toString() {
		StringBuffer buf = new StringBuffer("SharedObjectMsgEvent["); 		buf.append(getSenderSharedObjectID()).append(";").append( 				getRemoteContainerID()).append(";") 				.append(getSharedObjectMsg());
		buf.append("]"); 		return buf.toString();
	}
}