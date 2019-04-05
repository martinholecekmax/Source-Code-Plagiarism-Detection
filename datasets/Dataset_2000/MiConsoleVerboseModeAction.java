public class MiConsoleVerboseModeAction extends Action {
	private IConsole fConsole;
	public MiConsoleVerboseModeAction(IConsole console) {
		super();
		setToolTipText(MiConsoleMessages.verboseActionTooltip);
		setImageDescriptor(MIUIPlugin.imageDescriptorFromPlugin(MIUIPlugin.PLUGIN_ID, IMiConsoleImagesConst.IMG_VERBOSE_CONSOLE));
		fConsole = console;
	}
	public void updateStateAndEnablement() {
	    		GDBProcess gdbProcess = (GDBProcess) fConsole.getProcess();
		setEnabled(!gdbProcess.isTerminated());
		Target target = gdbProcess.getTarget();
		if (target != null) {
			setChecked(target.isVerboseModeEnabled());
		} else {
			setChecked(false);
		}
    }
	@Override
	public void run() {
		GDBProcess fProcess = (GDBProcess) fConsole.getProcess();
		fProcess.getTarget().enableVerboseMode(isChecked());
	}
}