public class NodeMotionListenerView extends JComponent {
	public NodeMotionListenerView(NodeView view) {
		super();
		this.movedView = view;
		MapView map = view.getMap();
		addMouseListener(map.getNodeMotionListener());
		addMouseMotionListener(map.getNodeMotionListener());
				this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
		final String helpMsg = Resources.getInstance().getResourceString(
				"node_location_help");
		this.setToolTipText(helpMsg);
	}
	private NodeView movedView;
	private boolean isMouseEntered;
	public NodeView getMovedView() {
		return movedView;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isMouseEntered()) {
			Graphics2D g2 = (Graphics2D) g;
			Controller controller = movedView.getMap().getController();
						Object renderingHint = controller.setEdgesRenderingHint(g2);
			Color color = g2.getColor();
			if (movedView.getModel().getHGap() <= 0) {
				g2.setColor(Color.RED);
				g.fillOval(0, 0, getWidth() - 1, getHeight() - 1);
			} else {
				g2.setColor(Color.BLACK);
				g.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
			}
			g2.setColor(color);
			Tools.restoreAntialiasing(g2, renderingHint);
		}
	}
	public boolean isMouseEntered() {
		return isMouseEntered;
	}
	public void setMouseEntered() {
		this.isMouseEntered = true;
								repaint();
	}
	public void setMouseExited() {
		this.isMouseEntered = false;
		repaint();
	}
}