public class ListAvailableSolutionStacksResultStaxUnmarshaller implements Unmarshaller<ListAvailableSolutionStacksResult, StaxUnmarshallerContext> {
    public ListAvailableSolutionStacksResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        ListAvailableSolutionStacksResult listAvailableSolutionStacksResult = new ListAvailableSolutionStacksResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 2;
        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return listAvailableSolutionStacksResult;
            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("SolutionStacks/member", targetDepth)) {
                    listAvailableSolutionStacksResult.getSolutionStacks().add(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("SolutionStackDetails/member", targetDepth)) {
                    listAvailableSolutionStacksResult.getSolutionStackDetails().add(SolutionStackDescriptionStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return listAvailableSolutionStacksResult;
                }
            }
        }
    }
    private static ListAvailableSolutionStacksResultStaxUnmarshaller instance;
    public static ListAvailableSolutionStacksResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new ListAvailableSolutionStacksResultStaxUnmarshaller();
        return instance;
    }
}