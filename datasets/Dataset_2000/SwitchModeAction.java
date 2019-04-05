public class SwitchModeAction extends Action {
	private SpecMolEditorContributor contributor;
	public SwitchModeAction(SpecMolEditorContributor contributor) {
		super("Switch Assignment mode on/off", Action.AS_CHECK_BOX);
		this.contributor = contributor;
	}
	@Override
	public void setChecked(boolean checked) {
		super.setChecked(checked);
		((SpecMolEditor)this.contributor.getActiveEditorPart()).getSpecmoleditorpage().setAssigmentMode(checked);
	}
}