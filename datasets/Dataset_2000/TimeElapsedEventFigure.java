public class TimeElapsedEventFigure extends org.eclipse.draw2d.Figure {
	public TimeElapsedEventFigure(ScenarioDiagram diagram) {
		m_diagram = diagram;
	}
	protected boolean useLocalCoordinates() {
		return(true);
	}
	public void setElapsedTime(String elapsedTime) {
		m_elapsedTime = elapsedTime;
		repaint();
	}
	
	protected void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		Rectangle r=getBounds();
				graphics.setBackgroundColor(ColorConstants.white);
		graphics.fillRectangle(r);
		if (m_diagram != null) {
			java.util.List list=m_diagram.getScenario().getRole();
			for (int i=0; i < list.size(); i++) {
				Role p=(Role)list.get(i);
				int xpos=ViewSupport.getChildXPosition(m_diagram.getScenario(),
							p, m_diagram);
				if (xpos > 0) {
					graphics.setBackgroundColor(ColorConstants.lightGray);
					graphics.fillPolygon(new int[]{
							xpos, r.y,
							xpos-10, r.y+(r.height/3),
							xpos, r.y+(r.height/3),
							xpos+10, r.y
					});
					graphics.fillPolygon(new int[]{
							xpos-10, r.y+(r.height/3),
							xpos+10, r.y +(2*r.height / 3),
							xpos+20, r.y +(2*r.height / 3),
							xpos, r.y+(r.height/3)
					});
					graphics.fillPolygon(new int[]{
							xpos+10, r.y +(2*r.height / 3),
							xpos, r.y +r.height,
							xpos+10, r.y +r.height,
							xpos+20, r.y +(2*r.height / 3)
					});
				}
			}
		}
		graphics.setForegroundColor(ColorConstants.black);
		org.eclipse.swt.graphics.Font font =
			new org.eclipse.swt.graphics.Font(org.eclipse.swt.widgets.Display.getCurrent(),
					"Arial",6,org.eclipse.swt.SWT.ITALIC);
		graphics.setFont(font);
		String text="Elapsed: ";
		if (m_elapsedTime != null) {
			text += m_elapsedTime;
		}
		graphics.drawText(text, r.x+5, r.y+2);
		font.dispose();
	}
	private String m_elapsedTime=null;
	private ScenarioDiagram m_diagram=null;
}