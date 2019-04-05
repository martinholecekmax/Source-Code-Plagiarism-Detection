public class SendReceiveSyncASyncSample {
	public static void main(String[] args) throws Throwable{
		EmbedBroker.start();
		MessageSender ms = new MessageSender();
		ms.sendJMSTextQueueMessage("queueLondon", "Test message london ");
		System.out.println("Message sent");
		MessageReceiver mr = new MessageReceiver();
		TextMessage msg    = mr.receiveSyncQueueMessage("queueLondon");
		System.out.println("Message Arrived: " + msg.getText());		
		mr.registerASyncMessageQueueListener("queueLondon", new MessageListener() {
			@Override
			public void onMessage(Message message) {
				try {
					System.out.println("Message Arrived on listener: " + ((TextMessage)message).getText()  );
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		 });
		 ms.sendJMSTextQueueMessage("queueLondon", "Test message london MS");
		 System.out.println("Message sent");	
	}
}