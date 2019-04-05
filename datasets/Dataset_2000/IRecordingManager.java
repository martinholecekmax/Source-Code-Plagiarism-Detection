public interface IRecordingManager
{
	public	void	startRecording(IConferenceParticipant presenter);
	public	void	stopRecording(IConferenceParticipant presenter);
	public	void	SetRecordingStopOptions(boolean saveRecording,
			boolean	uploadRecordingToBlipTV, String title,
			String description, String category, String keywords);
}