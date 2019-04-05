public class DescribeAutoScalingNotificationTypesResultStaxUnmarshaller implements Unmarshaller<DescribeAutoScalingNotificationTypesResult, StaxUnmarshallerContext> {
    public DescribeAutoScalingNotificationTypesResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        DescribeAutoScalingNotificationTypesResult describeAutoScalingNotificationTypesResult = new DescribeAutoScalingNotificationTypesResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 2;
        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return describeAutoScalingNotificationTypesResult;
            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("AutoScalingNotificationTypes/member", targetDepth)) {
                    describeAutoScalingNotificationTypesResult.getAutoScalingNotificationTypes().add(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return describeAutoScalingNotificationTypesResult;
                }
            }
        }
    }
    private static DescribeAutoScalingNotificationTypesResultStaxUnmarshaller instance;
    public static DescribeAutoScalingNotificationTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new DescribeAutoScalingNotificationTypesResultStaxUnmarshaller();
        return instance;
    }
}