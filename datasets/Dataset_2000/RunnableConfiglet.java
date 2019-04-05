@SuppressWarnings({ "NoopMethodInAbstractClass" })
public abstract class RunnableConfiglet extends DefaultConfiglet implements Runnable {
    
    private Thread thread;
    
    @Override
	public final synchronized void init(@NotNull final Logger loggerParam,
	                                 @NotNull String name, final Serializable data) {
		super.init(loggerParam, name, data);    		threadInit();
		thread = new Thread(this);
		thread.start();
	}
    
	public final void run() {
		MDC.put( "name", getName() );
		try {
			run_();
		}
		finally {
            MDC.remove( "name" );
		}
	}
    
    protected abstract void threadInit();
    
    public abstract void run_();
	@Override
	public synchronized void update(@NotNull final Serializable data) {
		super.update(data);    		thread.interrupt();
	}
	@Override
	public synchronized void shutdown() {
        super.shutdown();    		threadStop();
	}
    
	protected abstract void threadStop();
    
	public synchronized Thread getThread() {
		return thread;
	}
}