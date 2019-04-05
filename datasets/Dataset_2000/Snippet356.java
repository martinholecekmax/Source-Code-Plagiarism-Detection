public class Snippet356 {
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		FillLayout layout = new FillLayout();
		layout.marginHeight = layout.marginWidth = 10;
		shell.setLayout(layout);
		String string = "This is sample text with a link and some other link here.";
		final StyledText styledText = new StyledText (shell, SWT.MULTI | SWT.BORDER);
		styledText.setText(string);
		String link1 = "link";
		String link2 = "here";
		StyleRange style = new StyleRange();
		style.underline = true;
		style.underlineStyle = SWT.UNDERLINE_LINK;
		int[] ranges = {string.indexOf(link1), link1.length(), string.indexOf(link2), link2.length()}; 
		StyleRange[] styles = {style, style};
		styledText.setStyleRanges(ranges, styles);
		styledText.addListener(SWT.MouseDown, new Listener() {
			public void handleEvent(Event event) {
												if ((event.stateMask & SWT.MOD1) != 0) {
					try {
						int offset = styledText.getOffsetAtLocation(new Point (event.x, event.y));
						StyleRange style = styledText.getStyleRangeAtOffset(offset);
						if (style != null && style.underline && style.underlineStyle == SWT.UNDERLINE_LINK) {
							System.out.println("Click on a Link");
						}
					} catch (IllegalArgumentException e) {
											}
				}
			}
		});
		shell.setSize (600, 400);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ())
				display.sleep ();
		}
		display.dispose ();
	}
}