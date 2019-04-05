public class S_BoardRead extends ServerBasePacket {
	private static final String S_BoardRead = "[C] S_BoardRead";
	private static Logger _log = Logger.getLogger(S_BoardRead.class.getName());
	private byte[] _byte = null;
	public S_BoardRead(int number) {
		buildPacket(number);
	}
	private void buildPacket(int number) {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			con = L1DatabaseFactory.getInstance().getConnection();
			pstm = con.prepareStatement("SELECT * FROM board WHERE id=?");
			pstm.setInt(1, number);
			rs = pstm.executeQuery();
			while (rs.next()) {
				writeC(Opcodes.S_OPCODE_BOARDREAD);
				writeD(number);
				writeS(rs.getString(2));
				writeS(rs.getString(4));
				writeS(rs.getString(3));
				writeS(rs.getString(5));
			}
		} catch (SQLException e) {
			_log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		} finally {
			SQLUtil.close(rs);
			SQLUtil.close(pstm);
			SQLUtil.close(con);
		}
	}
	@Override
	public byte[] getContent() {
		if (_byte == null) {
			_byte = getBytes();
		}
		return _byte;
	}
	@Override
	public String getType() {
		return S_BoardRead;
	}
}