public class BSONException extends RuntimeException {
    private static final long serialVersionUID = -4415279469780082174L;
    
    public BSONException( final String msg ) {
        super( msg );
    }
    
    public BSONException( final int errorCode, final String msg ) {
        super( msg );
        _errorCode = errorCode;
    }
    
    public BSONException( final String msg , final Throwable t ) {
        super( msg,  t );
    }
    
    public BSONException( final int errorCode, final String msg, final Throwable t ) {
        super( msg,  t );
        _errorCode = errorCode;
    }
    
    public Integer getErrorCode() { return _errorCode; }
    
    public boolean hasErrorCode() { return (_errorCode != null); }
    private Integer _errorCode = null;
}