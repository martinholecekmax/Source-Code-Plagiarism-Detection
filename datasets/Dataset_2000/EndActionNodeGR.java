public class EndActionNodeGR extends AbstractActionNodeGR {
	private ForegroundStyle foreground;
	private BackgroundStyle background;
	private ForegroundStyle painterForeground;
	private BackgroundStyle painterBackground;
	public EndActionNodeGR(ActionNode actionNode, SwimmingLaneRepresentation aDrawing, boolean isInPalet) {
		super(actionNode, aDrawing, isInPalet);
						setWidth(31);
		setHeight(30);
		setIsFloatingLabel(true);
		foreground = ForegroundStyle.makeStyle(Color.BLACK);
		foreground.setLineWidth(0.2);
		background = BackgroundStyle.makeColoredBackground(getMainBgColor());
		setForeground(foreground);
		setBackground(background);
		setDimensionConstraints(DimensionConstraints.UNRESIZABLE);
		painterForeground = ForegroundStyle.makeStyle(Color.DARK_GRAY);
		painterForeground.setLineWidth(2.0);
		painterBackground = BackgroundStyle.makeColoredBackground(Color.DARK_GRAY);
		setShapePainter(new ShapePainter() {
			@Override
			public void paintShape(FGEShapeGraphics g) {
				g.useBackgroundStyle(painterBackground);
				g.fillCircle(0.2, 0.2, 0.6, 0.6);
			}
		});
	}
	
	@Override
	public double _getDefaultX() {
		return 250;
	}
	
	@Override
	public double _getDefaultY() {
		return (getActionNode().getParentPetriGraph().getIndexForEndNode(getActionNode()) * 50) + DEFAULT_BEGIN_Y_OFFSET;
	}
	@Override
	public double getDefaultLabelX() {
		if (getModel().hasLabelLocationForContext(ProcessEditorConstants.BASIC_PROCESS_EDITOR)) {
			return getModel().getLabelLocation(ProcessEditorConstants.BASIC_PROCESS_EDITOR).getX();
		}
		return getLeftBorder() + 15;
	}
	@Override
	public double getDefaultLabelY() {
		if (getModel().hasLabelLocationForContext(ProcessEditorConstants.BASIC_PROCESS_EDITOR)) {
			return getModel().getLabelLocation(ProcessEditorConstants.BASIC_PROCESS_EDITOR).getY();
		}
		return getTopBorder() + 40;
	}
}