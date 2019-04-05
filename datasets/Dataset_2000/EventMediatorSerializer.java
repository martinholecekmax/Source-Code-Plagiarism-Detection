public class EventMediatorSerializer extends AbstractMediatorSerializer {
    @Override
    protected OMElement serializeSpecificMediator(Mediator mediator) {
        EventMediator eventMediator = null;
        if (mediator instanceof EventMediator) {
            eventMediator = (EventMediator) mediator;
        } else {
            throw new SynapseException("Expecting an instance of EventMediator");
        }
        OMElement eventElement = fac.createOMElement("event", synNS);
        ValueSerializer vs = new ValueSerializer();
        if (eventMediator.getTopic() != null) {
            vs.serializeValue(eventMediator.getTopic(), "topic", eventElement);
        }
        if (eventMediator.getExpression() != null) {
            SynapseXPathSerializer.serializeXPath(eventMediator.getExpression(),
                    eventElement, "expression");
        }
        return eventElement;
    }
    @Override
    public String getMediatorClassName() {
        return EventMediator.class.getName();
    }
}