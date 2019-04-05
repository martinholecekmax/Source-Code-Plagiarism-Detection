public final class PrivateChatLoadedEventEncoder extends EventEncoder<PrivateChatLoadedEvent> {
	
	@Override
	public GamePacket encode(PrivateChatLoadedEvent event) {
		final GamePacketBuilder builder = new GamePacketBuilder(221);
		builder.put(DataType.BYTE, event.getId());
		return builder.toGamePacket();
	}
}