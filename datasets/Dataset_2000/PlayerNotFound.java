public class PlayerNotFound extends Exception {
	
	private static final long serialVersionUID = -6841087146104592092L;
	private final CommandSender sender;
	
	public PlayerNotFound(final String message, final CommandSender sender) {
		super(message);
		this.sender = sender;
	}
	
	public CommandSender getSender() {
		return sender;
	}
}