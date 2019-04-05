public class ItemOnObjectEvent extends GameEvent {
	
	public ItemOnObjectEvent(Player player, Packet packet) {
		super(player, packet);
	}
	
	@Override
	public void process() throws Exception {
		PacketReader reader = new PacketReader(getPacket());
		int y = reader.readShort(ByteForm.LITTLE);
		int itemId = reader.readShort();
		reader.readInt();
		int itemSlot = reader.readShort(ValueType.A);
		int objectId = reader.readShort(ValueType.A);
		int x = reader.readShort();
		Position pos = new Position(x, y, getPlayer().getPosition().getZ());
		int distance = Utilities.getDistance(pos, getPlayer().getPosition());
		new ItemOnObjectAction(getPlayer(), pos, distance, ObjectAction.ObjectActionType.FIRST, objectId, x, y, itemSlot, itemId).run();
	}
}