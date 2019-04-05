public class UnsubscribeObjectClass extends PorticoMessage
{
				private static final long serialVersionUID = 98121116105109L;
				private int classHandle;
	private int regionToken;
	private HashSet<Integer> attributes;
				public UnsubscribeObjectClass( int classHandle )
	{
		this.classHandle = classHandle;
		this.regionToken = PorticoConstants.NULL_HANDLE;
	}
	public UnsubscribeObjectClass( int classHandle, int regionToken )
	{
		this( classHandle );
		this.regionToken = regionToken;
	}
	public UnsubscribeObjectClass( int classHandle, HashSet<Integer> attributes )
	{
		this( classHandle );
		this.attributes = attributes;
	}
				public int getClassHandle()
	{
		return this.classHandle;
	}
	public void setClassHandle( int classHandle )
	{
		this.classHandle = classHandle;
	}
	public int getRegionToken()
	{
		return this.regionToken;
	}
	public void setRegionToken( int regionToken )
	{
		this.regionToken = regionToken;
	}
	public boolean usesDdm()
	{
		return this.regionToken != PorticoConstants.NULL_HANDLE;
	}
	public HashSet<Integer> getAttributes()
	{
		return this.attributes;
	}
	public void setAttributes( HashSet<Integer> attributes )
	{
		this.attributes = attributes;
	}
			}