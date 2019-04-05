public interface 
TrackerPeerSource 
{
	public static final int TP_UNKNOWN		= 0;
	public static final int TP_TRACKER		= 1;
	public static final int TP_HTTP_SEED	= 2;
	public static final int TP_DHT			= 3;
	public static final int TP_LAN			= 4;
	public static final int TP_PEX			= 5;
	public static final int TP_INCOMING		= 6;
	public static final int TP_PLUGIN		= 7;
	public static final int ST_UNKNOWN		= 0;
	public static final int ST_DISABLED		= 1;
	public static final int ST_STOPPED		= 2;
	public static final int ST_QUEUED		= 3;
	public static final int ST_UPDATING		= 4;
	public static final int ST_ONLINE 		= 5;
	public static final int ST_ERROR		= 6;
	public static final int ST_AVAILABLE	= 7;
	public static final int ST_UNAVAILABLE	= 8;
	public static final int ST_INITIALISING	= 9;
	public int
	getType();
	public String
	getName();
	public int
	getStatus();
	public String
	getStatusString();
	public int
	getSeedCount();
	public int
	getLeecherCount();
	public int
	getPeers();
	public int
	getSecondsToUpdate();
	public int
	getInterval();
	public int
	getMinInterval();
	public boolean
	isUpdating();
}