class LayoutComposite extends Composite {
	public LayoutComposite(Composite parent, int style) {
		super(parent, style);
		setMenu(parent.getMenu());
	}
	public Point computeSize(int wHint, int hHint, boolean changed) {
		Layout layout = getLayout();
		if (layout instanceof TableWrapLayout)
			return ((TableWrapLayout) layout).computeSize(this, wHint, hHint,
					changed);
		if (layout instanceof ColumnLayout)
			return ((ColumnLayout) layout).computeSize(this, wHint, hHint,
					changed);
		return super.computeSize(wHint, hHint, changed);
	}
}