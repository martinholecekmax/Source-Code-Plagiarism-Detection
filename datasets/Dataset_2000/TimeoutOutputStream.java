public class TimeoutOutputStream extends OutputStream {
	private final OutputStream dst;
	private final InterruptTimer myTimer;
	private int timeout;
	
	public TimeoutOutputStream(final OutputStream destination,
			final InterruptTimer timer) {
		dst = destination;
		myTimer = timer;
	}
	
	public int getTimeout() {
		return timeout;
	}
	
	public void setTimeout(final int millis) {
		if (millis < 0)
			throw new IllegalArgumentException(MessageFormat.format(
					JGitText.get().invalidTimeout, Integer.valueOf(millis)));
		timeout = millis;
	}
	@Override
	public void write(int b) throws IOException {
		try {
			beginWrite();
			dst.write(b);
		} catch (InterruptedIOException e) {
			throw writeTimedOut();
		} finally {
			endWrite();
		}
	}
	@Override
	public void write(byte[] buf) throws IOException {
		write(buf, 0, buf.length);
	}
	@Override
	public void write(byte[] buf, int off, int len) throws IOException {
		try {
			beginWrite();
			dst.write(buf, off, len);
		} catch (InterruptedIOException e) {
			throw writeTimedOut();
		} finally {
			endWrite();
		}
	}
	@Override
	public void flush() throws IOException {
		try {
			beginWrite();
			dst.flush();
		} catch (InterruptedIOException e) {
			throw writeTimedOut();
		} finally {
			endWrite();
		}
	}
	@Override
	public void close() throws IOException {
		try {
			beginWrite();
			dst.close();
		} catch (InterruptedIOException e) {
			throw writeTimedOut();
		} finally {
			endWrite();
		}
	}
	private void beginWrite() {
		myTimer.begin(timeout);
	}
	private void endWrite() {
		myTimer.end();
	}
	private static InterruptedIOException writeTimedOut() {
		return new InterruptedIOException(JGitText.get().writeTimedOut);
	}
}