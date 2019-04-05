public class DescribeSnapshotsResultStaxUnmarshaller implements Unmarshaller<DescribeSnapshotsResult, StaxUnmarshallerContext> {
    public DescribeSnapshotsResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        DescribeSnapshotsResult describeSnapshotsResult = new DescribeSnapshotsResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;
        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return describeSnapshotsResult;
            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("snapshotSet/item", targetDepth)) {
                    describeSnapshotsResult.getSnapshots().add(SnapshotStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return describeSnapshotsResult;
                }
            }
        }
    }
    private static DescribeSnapshotsResultStaxUnmarshaller instance;
    public static DescribeSnapshotsResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new DescribeSnapshotsResultStaxUnmarshaller();
        return instance;
    }
}