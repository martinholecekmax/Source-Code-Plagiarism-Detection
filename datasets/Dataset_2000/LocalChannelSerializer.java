class LocalChannelSerializer implements IChannelMessageSerializer {
		final private BlockingQueue<IProbeMessage> sendQueue;
		final private BlockingQueue<IProbeMessage> recvQueue;
		final private ILogger logger;
		LocalChannelSerializer(BlockingQueue<IProbeMessage> sendQ, BlockingQueue<IProbeMessage>recvQ, ILogger logger) {
			sendQueue = sendQ;
			recvQueue = recvQ;
			this.logger = logger;
		}
		public IProbeMessage readMessage() throws ChannelException {
			try {
				logger.debug("Entering recvQueue");
				IProbeMessage msg = recvQueue.take();
				logger.debug("Message read from local channel: " + msg);
				return msg;
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new ChannelException("readMessage() interrupted");
			}
		}
		public void sendMessage(IProbeMessage message) throws ChannelException {
			try {
				logger.debug("Sending message on local channel: " + message);
				sendQueue.put(message);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				throw new ChannelException("sendMessage() interrupted");
			}			
		}
		public void close() {
			throw new IllegalStateException("Attempt to close local channel");			
		}
}