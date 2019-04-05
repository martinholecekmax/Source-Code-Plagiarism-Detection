public abstract class CommonGraphicsEnvironment extends GraphicsEnvironment {
    @Override
    public Graphics2D createGraphics(BufferedImage bufferedImage) {
        return new BufferedImageGraphics2D(bufferedImage);
    }
    @Override
    public String[] getAvailableFontFamilyNames(Locale locale) {
        Font[] fonts = getAllFonts();
        ArrayList<String> familyNames = new ArrayList<String>();
        for (Font element : fonts) {
            String name = element.getFamily(locale);
            if (!familyNames.contains(name)) {
                familyNames.add(name);
            }
        }
        return familyNames.toArray(new String[familyNames.size()]);
    }
    @Override
    public Font[] getAllFonts() {
        return FontManager.getInstance().getAllFonts();
    }
    @Override
    public String[] getAvailableFontFamilyNames() {
        return FontManager.getInstance().getAllFamilies();
    }
}