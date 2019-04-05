public class IDATChunk extends CRCedChunk {
	private static final byte[] type = {(byte) 73, (byte) 68, (byte) 65, (byte) 84 };
	private int width;
	private int height;
	public IDATChunk(int width, int height) {
		super(type);
		this.width = width;
		this.height = height;
	}
	public byte[] getContentPayload() {
		byte[] payload = new byte[(width+1)*height];
		for(int i = 0; i<height ; i++) {
			int offset = i * (width+1);
						payload[offset++] = 0;
			for(int j = 0 ; j<width ; j++) {
				payload[offset+j] = (byte)(127);
			}
		}
		Deflater deflater = new Deflater( Deflater.DEFAULT_COMPRESSION );
	    ByteArrayOutputStream outBytes = new ByteArrayOutputStream((width+1)*height);
	    DeflaterOutputStream compBytes = new DeflaterOutputStream( outBytes, deflater );
	    try {
	    	compBytes.write(payload);
	    	compBytes.close();
	    } catch(Exception e) {
	    	e.printStackTrace();
	    }
	    byte[] compPayload = outBytes.toByteArray();
		return compPayload;
	}
}