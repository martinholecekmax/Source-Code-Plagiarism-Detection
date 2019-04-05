public class ASN1Integer extends ASN1Numeric {
    
    public static final int TAG = 0x02;
    
     public static final ASN1Identifier ID =
            new ASN1Identifier(ASN1Identifier.UNIVERSAL, false, TAG);
    
    
    public ASN1Integer(int content)
    {
        super( ID, content);
        return;
    }
    
    public ASN1Integer(long content)
    {
        super( ID, content);
        return;
    }
    
    public ASN1Integer(ASN1Decoder dec, InputStream in, int len)
       throws IOException
    {
        super(ID, (Long)dec.decodeNumeric(in, len));
        return;
    }
    
    
    public final void encode(ASN1Encoder enc, OutputStream out)
       throws IOException
    {
        enc.encode(this, out);
        return;
    }
    
    
    public String toString()
    {
        return super.toString() + "INTEGER: " + longValue();
    }
}