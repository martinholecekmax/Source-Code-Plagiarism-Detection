class AACAudioInputStream extends AsynchronousAudioInputStream {
	private final ADTSDemultiplexer adts;
	private final Decoder decoder;
	private final SampleBuffer sampleBuffer;
	private AudioFormat audioFormat = null;
	private byte[] saved;
	AACAudioInputStream(InputStream in, AudioFormat format, long length) throws IOException {
		super(in, format, length);
		adts = new ADTSDemultiplexer(in);
		decoder = new Decoder(adts.getDecoderSpecificInfo());
		sampleBuffer = new SampleBuffer();
	}
	@Override
	public AudioFormat getFormat() {
		if(audioFormat==null) {
						try {
				decoder.decodeFrame(adts.readNextFrame(), sampleBuffer);
				audioFormat = new AudioFormat(sampleBuffer.getSampleRate(), sampleBuffer.getBitsPerSample(), sampleBuffer.getChannels(), true, true);
				saved = sampleBuffer.getData();
			}
			catch(IOException e) {
				return null;
			}
		}
		return audioFormat;
	}
	public void execute() {
		try {
			if(saved==null) {
				decoder.decodeFrame(adts.readNextFrame(), sampleBuffer);
				buffer.write(sampleBuffer.getData());
			}
			else {
				buffer.write(saved);
				saved = null;
			}
		}
		catch(IOException e) {
			buffer.close();
			return;
		}
	}
}