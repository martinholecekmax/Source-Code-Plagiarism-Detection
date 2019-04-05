public class PullActor2 extends UntypedActor {
	ActorRef pullSocket = ZeroMQExtension.get(getContext().system())
			.newPullSocket(
					new SocketOption[] { new Connect("tcp:							new Listener(getSelf()) });
	LoggingAdapter log = Logging.getLogger(getContext().system(), this);
	@Override
	public void onReceive(Object message) throws Exception {
		if (message instanceof ZMQMessage) {
			ZMQMessage m = (ZMQMessage) message;
			String mesg = new String(m.payload(0));
			log.info("Received Message -> {}",mesg);
		}
	}
}