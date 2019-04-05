public class TestViewLabelProvider extends LabelProvider {
    @Override
    public Image getImage(final Object element) {
        final TestTreeObject node = (TestTreeObject) element;
        if (node.getType() == TestTreeObject.DESCR) {
            return null;
        }
        return drawType(node.getType());
    }
    @Override
    public String getText(final Object element) {
        final TestTreeObject node = (TestTreeObject) element;
        return node.getDescription();
    }
    private Image drawType(final int type) {
        final Image img = new Image(Display.getCurrent(), new Rectangle(2, 3,
                12, 12));
        final GC graphic = new GC(img);
        Color color;
        switch (type) {
        case TestTreeObject.WARN:
            color = new Color(Display.getCurrent(), 255, 255, 100);
            break;
        case TestTreeObject.SUCCESS:
            color = new Color(Display.getCurrent(), 60, 140, 10);
            break;
        case TestTreeObject.FAILOURE:
            color = new Color(Display.getCurrent(), 180, 20, 20);
            break;
        default:
            color = new Color(Display.getCurrent(), 255, 255, 255);
        }
        graphic.setForeground(color);
        graphic.setBackground(color);
        graphic.fillRectangle(0, 0, 12, 12);
        return img;
    }
}