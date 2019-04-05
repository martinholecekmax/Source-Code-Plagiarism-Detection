public class LabelFont extends LabelAttribute {
    private static final FontData DEFAULT_FONT = JFaceResources.getDefaultFontDescriptor().getFontData()[0];
    
    private FontData fFontData;
    public LabelFont() {
        this(DEFAULT_FONT);
    }
    public LabelFont(FontData fontData) {
        fFontData = fontData;
    }
    public FontData getFontData() {
        return fFontData;
    }
    public void setFontData(FontData fontData) {
        fFontData = fontData;
    }
    @Override
    public void updateAttribute(ILabelUpdate update, int columnIndex, IStatus status, Map<String, Object> properties) {
        update.setFontData(getFontData(), columnIndex);
    }
}