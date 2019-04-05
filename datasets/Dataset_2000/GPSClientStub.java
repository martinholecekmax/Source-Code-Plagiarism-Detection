public class GPSClientStub implements ServiceConnection {
	IGPSClient gps;
	Context context;
	public GPSClientStub(Context context) {
		this.context = context;
		GPSClient.bindTo(context, this);
	}
	
	public void close() {
		GPSClient.unbindFrom(context, this);
	}
	public IGPSClient get() {
		return gps;
	}
	@Override
	public void onServiceConnected(ComponentName name, IBinder service) {
		gps = (IGPSClient) service;
	}
	@Override
	public void onServiceDisconnected(ComponentName name) {
		gps = null;
	}
}