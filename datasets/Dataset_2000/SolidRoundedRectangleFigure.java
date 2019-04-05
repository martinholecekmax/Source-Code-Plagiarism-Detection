public class SolidRoundedRectangleFigure extends Figure {
	private Color color;
	private int x1, y1, x2, y2, diameter;
	
	public SolidRoundedRectangleFigure(Color color, int x1, int y1, int x2, int y2, int diameter) {
		this.color = color; this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
		this.diameter = diameter;
	}
	public void draw(FigureDrawContext fdc) {
		Rectangle r = fdc.toClientRectangle(x1, y1, x2, y2);
		fdc.gc.setBackground(color);
		fdc.gc.fillRoundRectangle(r.x, r.y, r.width, r.height, diameter, diameter);
	}
	public void addDamagedRegion(FigureDrawContext fdc, Region region) {
		region.add(fdc.toClientRectangle(x1, y1, x2, y2));
	}
}