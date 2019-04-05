public class WholeSmsMessage {
	
	private final List<SmsMessage> parts;
	WholeSmsMessage(SmsMessage[] parts) {
		this.parts = Collections.unmodifiableList(Arrays.asList(parts));
	}
	public String getMessageBody() {
		StringBuilder bob = new StringBuilder();
		for(SmsMessage m : parts) {
			bob.append(m.getMessageBody());
		}
		return bob.toString();
	}
	public String getOriginatingAddress() {
		return parts.get(0).getOriginatingAddress();
	}
}