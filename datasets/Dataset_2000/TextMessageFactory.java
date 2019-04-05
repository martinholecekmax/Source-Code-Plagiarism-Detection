public class TextMessageFactory implements MessageFactory {
    @Override
    public Message toMessage(final Payload payload, final Session session) {
        try {
            return createMessage(payload.asString(), session);
        } catch (JMSException e) {
            throw new JmsException(e);
        }
    }
    private TextMessage createMessage(final String text, final Session session) throws JMSException {
        return session.createTextMessage(text);
    }
}