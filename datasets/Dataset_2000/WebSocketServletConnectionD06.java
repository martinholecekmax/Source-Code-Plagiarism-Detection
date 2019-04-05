public class WebSocketServletConnectionD06 extends WebSocketConnectionD06 implements WebSocketServletConnection
{
    private final WebSocketFactory factory;
    public WebSocketServletConnectionD06(WebSocketFactory factory, WebSocket websocket, EndPoint endpoint, WebSocketBuffers buffers, long timestamp, int maxIdleTime, String protocol)
            throws IOException
    {
        super(websocket,endpoint,buffers,timestamp,maxIdleTime,protocol);
        this.factory = factory;
    }
    
    public void handshake(HttpServletRequest request, HttpServletResponse response, String subprotocol) throws IOException
    {
        String key = request.getHeader("Sec-WebSocket-Key");
        response.setHeader("Upgrade","WebSocket");
        response.addHeader("Connection","Upgrade");
        response.addHeader("Sec-WebSocket-Accept",hashKey(key));
        if (subprotocol!=null)
        {
            response.addHeader("Sec-WebSocket-Protocol",subprotocol);
        }
        response.sendError(101);
        onFrameHandshake();
        onWebSocketOpen();
    }
    @Override
    public void onClose()
    {
        super.onClose();
        factory.removeConnection(this);
    }
}