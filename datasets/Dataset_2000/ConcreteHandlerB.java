public class ConcreteHandlerB implements IChainOfResposibility {
	private IChainOfResposibility next;
	
	@Override
	public void setNextHandler(IChainOfResposibility handler) {
		this.next = handler;
	}
	
	@Override
	public void handleRequest(String message) {
		if (message == null || message.endsWith("@mail.ru")) {
			if (next == null)
				throw new RuntimeException(
						"Don't have appropriate handler for message: "
								+ message);
			next.handleRequest(message);
		} else {
			System.out.println("Handling message in " + this.getClass());
		}
	}
}