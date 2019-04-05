public class ActionsUpdater {
	private IEnabledTarget[] fActions;
	private int fNumVoters;
	private int fNumOfVotes = 0;
	private boolean fDone = false;
	private boolean fEnabled = true;
	public ActionsUpdater(IEnabledTarget[] actions, int numVoters) {
		fActions = actions;
		fNumVoters = numVoters;
	}
	public synchronized void setEnabled(boolean result) {
		fNumOfVotes++;
		if (fEnabled) {
			fEnabled = result;
		}
		done();
	}
	private synchronized void done() {
		if (!fDone) {
			if (!fEnabled || fNumOfVotes == fNumVoters) {
				fDone = true;
				for (int i = 0; i < fActions.length; i++) {
					fActions[i].setEnabled(fEnabled);
				}
			}
		}
	}
}