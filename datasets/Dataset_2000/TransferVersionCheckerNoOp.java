public class TransferVersionCheckerNoOp implements TransferVersionChecker
{
    private static Log logger = LogFactory.getLog(TransferVersionCheckerNoOp.class);
    public boolean checkTransferVersions(TransferVersion from, TransferVersion to)
    {
        logger.debug("checkTransferVersions from:" + from + ", to:" + to);        
        return true;
    }
}