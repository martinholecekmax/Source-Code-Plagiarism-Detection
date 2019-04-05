public abstract class WorkbenchRequestHandler {
    public static final String HTTP_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final String HTTP_DATE_GMT_TIMEZONE = "GMT";
    
    public abstract void processMessage(ChannelHandlerContext ctx, MessageEvent e) throws Exception;
}