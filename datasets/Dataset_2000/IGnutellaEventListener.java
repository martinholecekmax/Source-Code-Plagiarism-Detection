public interface IGnutellaEventListener {
	
	public enum FailCause {
		Denied, Timeout;
	}
	public enum ConnBreakCause {
		Cancel, Timeout;
	}
	
	public void connectionStarted(GnutellaLikeOverlayContact invoker,
			GnutellaLikeOverlayContact receiver, int connectionUID);
	
	public void connectionSucceeded(GnutellaLikeOverlayContact invoker,
			GnutellaLikeOverlayContact receiver, int connectionUID);
	
	public void connectionFailed(GnutellaLikeOverlayContact invoker,
			GnutellaLikeOverlayContact receiver, int connectionUID,
			FailCause cause);
	
	public void connectionBreak(GnutellaLikeOverlayContact notifiedNode, 
			GnutellaLikeOverlayContact opponent, 
			ConnBreakCause cause);
	
	public void pingTimeouted(GnutellaLikeOverlayContact invoker,
			GnutellaLikeOverlayContact receiver);
	
	public void queryStarted(GnutellaLikeOverlayContact initiator, Query query);
	
	public void querySucceeded(GnutellaLikeOverlayContact initiator, Query query,
			int hits);
	
	public void queryFailed(GnutellaLikeOverlayContact initiator, Query query,
			int hits);
	
	public void queryMadeHop(int queryUID, GnutellaLikeOverlayContact hopContact);
	
	public void reBootstrapped(GnutellaLikeOverlayContact c);
}