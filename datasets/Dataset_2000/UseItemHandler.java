public class UseItemHandler implements PacketHandler {
	private static final Logger log = LoggerFactory.getLogger(UseItemHandler.class);
	protected final Map<Integer, ItemHandler> itemHandlers;
	protected final ItemHandler equipableHandler;
	protected final ItemHandler edibleHandler;
	public UseItemHandler() {
		itemHandlers = this.loadItemHandlers();
		equipableHandler = new EquipableHandler();
		edibleHandler = new EdibleHandler();
	}
	private Map<Integer, ItemHandler> loadItemHandlers() {
		Map<Integer, ItemHandler> handlers = new HashMap<Integer, ItemHandler>();
		URL path = ItemHandler.class.getResource("itemhandlers.xml");
		if (path == null) {
						throw new RuntimeException("Unable to find itemhandlers.xml resource");
		}
		PersistenceManager.ItemHandler[] definitions = (PersistenceManager.ItemHandler[]) PersistenceManager.load(path);
		for (PersistenceManager.ItemHandler definition : definitions) {
			try {
				ItemHandler handler = (ItemHandler) definition.handler.newInstance();
				for (int id : definition.ids)
					handlers.put(id, handler);
			}
			catch (Exception e) {
								throw new RuntimeException("Error loading item handlers: " + e.getMessage());
			}
		}
		if (log.isDebugEnabled())
			log.debug("Loaded " + handlers.size() + " item handlers");
		return handlers;
	}
	@Override
	public void handlePacket(Server server, WorldManager world, Player player, Packet packet) throws Exception {
		int index = packet.getByte();
		Item item = player.getInventory().get(index);
		if (item == null) {
			log.warn("Player attempted to use null item: " + player);
			return;
		}
		ItemHandler handler = itemHandlers.get(item.getID());
				if (handler == null) {
						if (item.isEdible())
				handler = edibleHandler;
						else if (item.isEquipable())
				handler = equipableHandler;
		}
				if (handler == null) {
			player.sendMessage(item.getDescription());
			return;
		}
				handler.handleItem(server, world, player, item, index);
	}
}