public final class LdifEOFPart implements LdifPart
{
    private static final long serialVersionUID = -8527682569842893613L;
    private int offset;
    protected LdifEOFPart()
    {
    }
    public LdifEOFPart( int offset )
    {
        this.offset = offset;
    }
    public final int getOffset()
    {
        return this.offset;
    }
    public final int getLength()
    {
        return 0;
    }
    public final String toRawString()
    {
        return "";     }
    public final String toFormattedString( LdifFormatParameters formatParameters )
    {
        return "";     }
    public final String toString()
    {
        String text = toRawString();
        text = text.replaceAll( "\n", "\\\\n" );         text = text.replaceAll( "\r", "\\\\r" );         return getClass().getName() + " (" + getOffset() + "," + getLength() + "): '" + text + "'";     }
    public final boolean isValid()
    {
        return true;
    }
    public final String getInvalidString()
    {
        return "";     }
    public final void adjustOffset( int adjust )
    {
        this.offset += adjust;
    }
}