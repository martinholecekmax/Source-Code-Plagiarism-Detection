@Plugin(type = OptionsPlugin.class, menu = {
	@Menu(label = MenuConstants.EDIT_LABEL, weight = MenuConstants.EDIT_WEIGHT,
		mnemonic = MenuConstants.EDIT_MNEMONIC),
	@Menu(label = "Options", mnemonic = 'o'),
	@Menu(label = "Fonts...", weight = 3) })
public class OptionsFont extends OptionsPlugin {
		@Parameter(label = "Font")
	private String font = "SansSerif";
	@Parameter(label = "Size", min = "8", max = "72")
	private int fontSize = 18;
		@Parameter(label = "Style", choices = { "Plain", "Bold", "Italic",
		"Bold + Italic" })
	private String fontStyle = "Plain";
	@Parameter(label = "Smooth")
	private boolean fontSmooth = true;
		public String getFont() {
		return font;
	}
	public int getFontSize() {
		return fontSize;
	}
	public String getFontStyle() {
		return fontStyle;
	}
	public boolean isFontSmooth() {
		return fontSmooth;
	}
	public void setFont(final String font) {
		this.font = font;
	}
	public void setFontSize(final int fontSize) {
		this.fontSize = fontSize;
	}
	public void setFontStyle(final String fontStyle) {
		this.fontStyle = fontStyle;
	}
	public void setFontSmooth(final boolean fontSmooth) {
		this.fontSmooth = fontSmooth;
	}
}