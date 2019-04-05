public class ChatWithStylesAppliedAtRuntime extends AbstractChatExample {
	public ChatWithStylesAppliedAtRuntime() {
		super(null);
	}
	public static void main(String[] args) {
		ChatWithStylesAppliedAtRuntime chat = new ChatWithStylesAppliedAtRuntime();
		try {
			chat.display();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}