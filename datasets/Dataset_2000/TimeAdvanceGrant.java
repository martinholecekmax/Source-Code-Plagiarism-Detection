public class TimeAdvanceGrant extends PorticoMessage
{
				private static final long serialVersionUID = 98121116105109L;
				private double time;
				public TimeAdvanceGrant( double time )
	{
		setTime( time );
	}
				public double getTime()
	{
		return this.time;
	}
	
	public void setTime( double time )
	{
		this.time = time;
		this.timestamp = time;
	}
	@Override
	public boolean isTimeAdvance()
	{
		return true;
	}
			}