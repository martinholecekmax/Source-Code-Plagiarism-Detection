public class InstanceStatusDetailsStaxUnmarshaller implements Unmarshaller<InstanceStatusDetails, StaxUnmarshallerContext> {
    public InstanceStatusDetails unmarshall(StaxUnmarshallerContext context) throws Exception {
        InstanceStatusDetails instanceStatusDetails = new InstanceStatusDetails();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;
        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return instanceStatusDetails;
            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("name", targetDepth)) {
                    instanceStatusDetails.setName(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("status", targetDepth)) {
                    instanceStatusDetails.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("impairedSince", targetDepth)) {
                    instanceStatusDetails.setImpairedSince(DateStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return instanceStatusDetails;
                }
            }
        }
    }
    private static InstanceStatusDetailsStaxUnmarshaller instance;
    public static InstanceStatusDetailsStaxUnmarshaller getInstance() {
        if (instance == null) instance = new InstanceStatusDetailsStaxUnmarshaller();
        return instance;
    }
}