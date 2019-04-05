public class TicketCreationException extends TicketException {
    
    private static final long serialVersionUID = 5501212207531289993L;
    
    private static final String CODE = "CREATION_ERROR";
    
    public TicketCreationException() {
        super(CODE);
    }
    
    public TicketCreationException(final Throwable throwable) {
        super(CODE, throwable);
    }
}