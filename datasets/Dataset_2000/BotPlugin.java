public abstract class BotPlugin {
	Qw0rumBot bot = null;
	
	public BotPlugin(Qw0rumBot b) {
		this.bot = b;
	}
	
	public void onMessage(String channel, String sender, String login,
			String hostname, String message) {
	}
	
	public void onModeChange() {
	};
	
	public void onOp(String channel, String sourceNick, String sourceLogin,
			String sourceHostname, String recipient) {
	}
	
	public void onDeop(String channel, String sourceNick, String sourceLogin,
			String sourceHostname, String recipient) {
	}
	
	public void onJoin(String channel, String sender, String login,
			String hostname) {
	}
	
	public void onPart(String channel, String sender, String login,
			String hostname) {
	}
	
	public void onTick() {
	}
}