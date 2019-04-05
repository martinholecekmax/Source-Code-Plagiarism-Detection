public class InitLdapMessage extends GrammarAction<LdapMessageContainer<MessageDecorator<? extends Message>>>
{
    
    private static final Logger LOG = LoggerFactory.getLogger( InitLdapMessage.class );
    
    public InitLdapMessage()
    {
        super( "LdapMessage initialization" );
    }
    
    public void action( LdapMessageContainer<MessageDecorator<? extends Message>> container ) throws DecoderException
    {
        TLV tlv = container.getCurrentTLV();
                if ( tlv.getLength() == 0 )
        {
            LOG.error( I18n.err( I18n.ERR_04066 ) );
                        throw new DecoderException( I18n.err( I18n.ERR_04067 ) );
        }
    }
}