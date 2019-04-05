public class GetAvailableCommand extends PIOCommand {
	public GetAvailableCommand(int pioSelector) {
		super(pioSelector);
	}
	public ReplyEnvelope execute(IAT91_PIO pio) throws Exception {
		return new NumberReplyEnvelope(getUid(), pio.available());
	}
}