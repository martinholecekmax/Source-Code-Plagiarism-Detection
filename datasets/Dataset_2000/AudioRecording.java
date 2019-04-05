public interface AudioRecording extends AudioResource, AudioStream
{
	
	void play();
	
	void pause();
	boolean isPlaying();
	
	void loop(int count);
	
	void setLoopPoints(int start, int stop);
	
	int getLoopCount();
	
	int getMillisecondPosition();
	
	void setMillisecondPosition(int pos);
	
	int getMillisecondLength();
	
	AudioMetaData getMetaData();
}