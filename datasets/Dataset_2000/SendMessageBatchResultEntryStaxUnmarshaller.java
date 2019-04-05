public class SendMessageBatchResultEntryStaxUnmarshaller implements Unmarshaller<SendMessageBatchResultEntry, StaxUnmarshallerContext> {
    public SendMessageBatchResultEntry unmarshall(StaxUnmarshallerContext context) throws Exception {
        SendMessageBatchResultEntry sendMessageBatchResultEntry = new SendMessageBatchResultEntry();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 2;
        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return sendMessageBatchResultEntry;
            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("Id", targetDepth)) {
                    sendMessageBatchResultEntry.setId(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("MessageId", targetDepth)) {
                    sendMessageBatchResultEntry.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("MD5OfMessageBody", targetDepth)) {
                    sendMessageBatchResultEntry.setMD5OfMessageBody(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return sendMessageBatchResultEntry;
                }
            }
        }
    }
    private static SendMessageBatchResultEntryStaxUnmarshaller instance;
    public static SendMessageBatchResultEntryStaxUnmarshaller getInstance() {
        if (instance == null) instance = new SendMessageBatchResultEntryStaxUnmarshaller();
        return instance;
    }
}