@Plugin(
	menu = {
		@Menu(label = MenuConstants.IMAGE_LABEL,
			weight = MenuConstants.IMAGE_WEIGHT,
			mnemonic = MenuConstants.IMAGE_MNEMONIC),
		@Menu(label = "Axes", mnemonic = 'a'),
		@Menu(label = "Set Active Axis...") }, headless = true)
public class SetActiveAxis extends DynamicCommand {
		private static final String AXIS_NAME = "axisName";
		@Parameter(type = ItemIO.BOTH)
	private ImageDisplay display;
	@Parameter(persist = false, initializer = "initAxisName")
	private String axisName;
	@Parameter
	private AnimationService animationService;
		public ImageDisplay getDisplay() {
		return display;
	}
	public void setDisplay(final ImageDisplay display) {
		this.display = display;
	}
	public AxisType getAxis() {
		return Axes.get(axisName);
	}
	public void setAxis(final AxisType axis) {
		axisName = axis.toString();
	}
		@Override
	public void run() {
		final AxisType axis = getAxis();
		if (axis != null) {
			display.setActiveAxis(axis);
			int axisIndex = display.getAxisIndex(axis);
			long last = display.getExtents().dimension(axisIndex) - 1;
			Animation a = animationService.getAnimation(display);
			boolean active = a.isActive();
			if (active) a.stop();
			a.setAxis(axis);
			a.setFirst(0);
			a.setLast(last);
			if (active) a.start();
		}
	}
		protected void initAxisName() {
		@SuppressWarnings("unchecked")
		final DefaultModuleItem<String> axisNameItem =
			(DefaultModuleItem<String>) getInfo().getInput(AXIS_NAME);
		final AxisType[] axes = display.getAxes();
		final ArrayList<String> choices = new ArrayList<String>();
		for (final AxisType a : axes) {
			if (a.isXY()) continue;
			choices.add(a.getLabel());
		}
		axisNameItem.setChoices(choices);
	}
}