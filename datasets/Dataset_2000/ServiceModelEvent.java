public class ServiceModelEvent extends EventObject implements IServiceModelEvent {
	private static final long serialVersionUID = 1L;
	private int type;
	private IServiceProvider oldProvider;
	public ServiceModelEvent(Object source, int type) {
		super(source);
		this.type = type;
	}
	public ServiceModelEvent(Object source, int type, IServiceProvider oldProvider) {
		this(source, type);
		this.oldProvider = oldProvider;
	}
	public int getType() {
		return type;
	}
	public IServiceProvider getOldProvider() {
		return oldProvider;
	}
}