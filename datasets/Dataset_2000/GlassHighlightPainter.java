public class GlassHighlightPainter implements SubstanceHighlightPainter {
	
	public static final String DISPLAY_NAME = "Glass";
	
	protected GlassFillPainter painter;
	
	public GlassHighlightPainter() {
		this.painter = new GlassFillPainter();
	}
	public String getDisplayName() {
		return DISPLAY_NAME;
	}
	@Override
	public void paintHighlight(Graphics2D graphics, Component comp, int width,
			int height, SubstanceColorScheme colorScheme) {
		Graphics2D g2d = (Graphics2D) graphics.create();
		g2d.translate(-3, -3);
		this.painter
				.paintContourBackground(g2d, comp, width + 6, height + 6,
						new Rectangle(width + 6, height + 6), false,
						colorScheme, false);
		g2d.dispose();
	}
}