public class SpringAmqpConsumer implements MessageListener {
	private final Logger logger = Logger.getLogger(SpringAmqpConsumer.class);
	public void onMessage(Message message) {
		logger.info(">>> RECEIVING : " + message.getMessageProperties().getReceivedRoutingKey() + " " + message);
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context-receiver.xml");
	}
}