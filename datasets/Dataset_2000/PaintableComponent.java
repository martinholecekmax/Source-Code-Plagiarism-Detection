public interface PaintableComponent {
	
	public Component getComponent();
	
	public Transparency getTransparency();
	
	public void paintBackground( Graphics g );
	
	public void paintForeground( Graphics g );
	
	public void paintBorder( Graphics g );
	
	public void paintChildren( Graphics g );
	
	public void paintOverlay( Graphics g );
}