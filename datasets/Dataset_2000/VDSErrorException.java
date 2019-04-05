public class VDSErrorException extends VDSGenericException implements java.io.Serializable {
                        public VDSErrorException(RuntimeException baseException) {
        super("VDSErrorException: ", baseException);
    }
    public VDSErrorException(String errorStr) {
        super("VDSErrorException: " + errorStr);
    }
    public VDSErrorException(VdcBllErrors errorCode) {
        super(errorCode);
    }
    public VDSErrorException(VdcBllErrors errorCode, String errorStr) {
        super(errorCode, errorStr);
    }
}