public class Snippet256 {
public static void main(String[] args) {
	Display display = new Display();
	final Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.DOUBLE_BUFFERED);	
	shell.setText("Underline, Strike Out");
	Font font = shell.getFont();
	String text = "Here is some text that is underlined or struck out or both.";
	final TextLayout layout = new TextLayout(display);
	layout.setText(text);
	TextStyle style1 = new TextStyle(font, null, null);
	style1.underline = true;
	layout.setStyle(style1, 26, 35);
	TextStyle style2 = new TextStyle(font, null, null);
	style2.strikeout = true;
	layout.setStyle(style2, 40, 49);
	TextStyle style3 = new TextStyle(font, null, null);
	style3.underline = true;
	style3.strikeout = true;
	layout.setStyle(style3, 54, 57);
	shell.addListener(SWT.Paint, new Listener() {
		public void handleEvent(Event event) {
			Point point = new Point(10, 10);
			int width = shell.getClientArea().width - 2 * point.x;
			layout.setWidth(width);
			layout.draw(event.gc, point.x, point.y);		
		}
	});
	shell.open();
	while (!shell.isDisposed()) {
		if (!display.readAndDispatch()) display.sleep();
	}
	layout.dispose();		
	display.dispose();
}
}