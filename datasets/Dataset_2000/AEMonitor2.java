public class 
AEMonitor2 
{
	ReentrantLock	lock = new ReentrantLock();
	public
	AEMonitor2(
		String			_name )
	{
	}
	public void
	enter()
	{
		lock.lock();
	}
		
	public boolean
	enter(
		int	max_millis )
	{
		try{
			if ( lock.tryLock( max_millis, TimeUnit.MILLISECONDS )){
				return( true );
			}else{
				return( false );
			}
		}catch( Throwable e ){
			Debug.out( e );
			return( false );
		}
	}
	public void
	exit()
	{
		try{			
			lock.unlock();
		}finally{
		}
	}
	public boolean
	isHeld()
	{		
		return( lock.isHeldByCurrentThread());
	}
	public boolean
	hasWaiters()
	{
		return( lock.getQueueLength() > 0 );
	}
}