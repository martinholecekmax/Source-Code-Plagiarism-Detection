public class DeleteResponseDecorator extends ResponseDecorator<DeleteResponse>
    implements DeleteResponse
{
    
    private int deleteResponseLength;
    
    public DeleteResponseDecorator( LdapApiService codec, DeleteResponse decoratedMessage )
    {
        super( codec, decoratedMessage );
    }
    
    public void setDeleteResponseLength( int deleteResponseLength )
    {
        this.deleteResponseLength = deleteResponseLength;
    }
    
    public int getDeleteResponseLength()
    {
        return deleteResponseLength;
    }
                
    public int computeLength()
    {
        int deleteResponseLength = ( ( LdapResultDecorator ) getLdapResult() ).computeLength();
        setDeleteResponseLength( deleteResponseLength );
        return 1 + TLV.getNbBytes( deleteResponseLength ) + deleteResponseLength;
    }
    
    public ByteBuffer encode( ByteBuffer buffer ) throws EncoderException
    {
        try
        {
                        buffer.put( LdapConstants.DEL_RESPONSE_TAG );
            buffer.put( TLV.getBytes( getDeleteResponseLength() ) );
                        ( ( LdapResultDecorator ) getLdapResult() ).encode( buffer );
        }
        catch ( BufferOverflowException boe )
        {
            throw new EncoderException( I18n.err( I18n.ERR_04005 ) );
        }
        return buffer;
    }
}