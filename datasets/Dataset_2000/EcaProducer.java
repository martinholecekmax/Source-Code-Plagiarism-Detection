public class EcaProducer extends SedaProducer {
    EcaEndpoint ecaEndpoint;
    public EcaProducer(EcaEndpoint endpoint, BlockingQueue<Exchange> queue, WaitForTaskToComplete waitForTaskToComplete, long timeout) {
        super(endpoint, queue, waitForTaskToComplete, timeout);
        this.ecaEndpoint = endpoint;
    }
    @Override
    public boolean process(Exchange exchange, AsyncCallback callback) {
                exchange.getIn().setHeader("EcaRouteId", exchange.getFromRouteId());
        return super.process(exchange, callback);
    }
}