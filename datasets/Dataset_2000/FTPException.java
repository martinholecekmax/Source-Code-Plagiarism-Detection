public class FTPException extends ApplicationException {
	private int code;
	private String msg;
	public FTPException(String action, FTPClient client) {
		super("action ["+action+"] from tag ftp failed", client.getReplyString());
						code = client.getReplyCode();
		msg = client.getReplyString();
	}
	public CatchBlock getCatchBlock(Config config) {
		CatchBlock cb = super.getCatchBlock(config);
		cb.setEL("Cause", msg);
		cb.setEL("Code", Caster.toDouble(code));
		return cb;
	}
}