public class ChannelStats
{
		private static final AtomicLong httpReceivedMessages = new AtomicLong(0);
	public static void newHttpMessageReceived()
	{
		httpReceivedMessages.incrementAndGet();
	}
	public static long getHttpReceivedMessagesAndReset()
	{
		return httpReceivedMessages.getAndSet(0);
	}
		private static final AtomicLong dropboxReceivedMessages = new AtomicLong(0);
	public static void newDropboxMessageReceived()
	{
		dropboxReceivedMessages.incrementAndGet();
	}
	public static long getDropboxReceivedMessagesAndReset()
	{
		return dropboxReceivedMessages.getAndSet(0);
	}
}