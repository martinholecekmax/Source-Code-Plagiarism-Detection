public class ShowHideLabelsHandler extends AbstractGraphicalCommandHandler {
	
	public static final String parameterID = "show_hide_link_label_parameter"; 	
	public ShowHideLabelsHandler() {
		super(parameterID);
	}
	
	public ShowHideLabelsHandler(String parameter) {
		super(parameterID, parameter);
	}
	
	@Override
	protected Command getCommand() throws ExecutionException {
		ShowHideLabelsAction action = new ShowHideLabelsAction(this.parameter, getSelectedElements());
		return action.getCommand();
	}
	
	@Override
	public boolean isEnabled() {
		if(this.parameter.equals(ShowHideLabelsAction.MANAGE_PARAMETER)) {
						ShowHideLabelsAction action = new ShowHideLabelsAction(ShowHideLabelsAction.SHOW_PARAMETER, getSelectedElements());
			return action.getCommand().canExecute();
		} else {
			return super.isEnabled();
		}
	}
}