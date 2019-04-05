public abstract class DragPaintSession extends BasicPaintSession {
	
	private boolean dragInProgress = false;
	
	private Point anchorPosition = new Point(-1, -1);
	
	private Point tempPosition = new Point(-1, -1);
	
	protected DragPaintSession(PaintSurface paintSurface) {
		super(paintSurface);
	}
	
	public void beginSession() {
		getPaintSurface().
			setStatusMessage(PaintExample.getResourceString("session.DragInteractivePaint.message"));
		anchorPosition.x = -1;
		dragInProgress = false;
	}
	
	public void endSession() {
	}
	
	public void resetSession() {
		getPaintSurface().clearRubberbandSelection();
		anchorPosition.x = -1;
		dragInProgress = false;
	}
	
	public void mouseDown(MouseEvent event) {
		if (event.button != 1) return;
		if (dragInProgress) return; 		dragInProgress = true;
		anchorPosition.x = event.x;
		anchorPosition.y = event.y;
	}
	
	public void mouseDoubleClick(MouseEvent event) {
	}
	
	public void mouseUp(MouseEvent event) {
		if (event.button != 1) {
			resetSession(); 			return;
		}
		if (! dragInProgress) return; 		dragInProgress = false;
		if (anchorPosition.x == -1) return; 		getPaintSurface().commitRubberbandSelection();
	}
	
	public void mouseMove(MouseEvent event) {
		final PaintSurface ps = getPaintSurface();
		if (! dragInProgress) {
			ps.setStatusCoord(ps.getCurrentPosition());
			return;
		}
		ps.setStatusCoordRange(anchorPosition, ps.getCurrentPosition());
		ps.clearRubberbandSelection();
		tempPosition.x = event.x;
		tempPosition.y = event.y;
		ps.addRubberbandSelection(createFigure(anchorPosition, tempPosition));
	}
	
	protected abstract Figure createFigure(Point anchor, Point cursor);
}