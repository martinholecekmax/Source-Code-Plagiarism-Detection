public class AppendCommandParser extends AbstractImapCommandParser {
    public AppendCommandParser() {
        super(ImapCommand.authenticatedStateCommand(ImapConstants.APPEND_COMMAND_NAME));
    }
    
    public Flags optionalAppendFlags(ImapRequestLineReader request) throws DecodingException {
        char next = request.nextWordChar();
        if (next == '(') {
            return request.flagList();
        } else {
            return null;
        }
    }
    
    public Date optionalDateTime(ImapRequestLineReader request) throws DecodingException {
        char next = request.nextWordChar();
        if (next == '"') {
            return request.dateTime();
        } else {
            return null;
        }
    }
    
    protected ImapMessage decode(ImapCommand command, ImapRequestLineReader request, String tag, ImapSession session) throws DecodingException {
        String mailboxName = request.mailbox();
        Flags flags = optionalAppendFlags(request);
        if (flags == null) {
            flags = new Flags();
        }
        Date datetime = optionalDateTime(request);
        if (datetime == null) {
            datetime = new Date();
        }
        request.nextWordChar();
        final ImapMessage result = new AppendRequest(command, mailboxName, flags, datetime, request.consumeLiteral(true), tag);
        return result;
    }
}