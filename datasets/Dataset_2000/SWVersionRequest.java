public class SWVersionRequest extends Request{
	public SWVersionRequest() {
	}
	@Override
	protected byte getMessageId() {
		return Constants.REQUEST_SW_VERSION;
	}
	@Override
	protected int getPayloadSize() {
		return Constants.SIZE_BYTE; 	}
	@Override
	protected void WritePayload(DataOutputStream writer) throws IOException {
		writer.writeByte(Constants.MSG_OK);
	}
}