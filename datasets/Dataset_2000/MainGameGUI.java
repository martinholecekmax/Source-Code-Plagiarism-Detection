public class MainGameGUI extends PIContainer {
	
	private Client client;
	
	private MainGameMenu menu;
	
	public MainGameGUI(final Client cli) {
		this.client = cli;
		this.menu = new MainGameMenu(this);
		add(menu);
		setLocation(0, 0);
		compile();
	}
	
	public final Client getClient() {
		return client;
	}
}