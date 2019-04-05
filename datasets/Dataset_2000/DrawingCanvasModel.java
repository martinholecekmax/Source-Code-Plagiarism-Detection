public class DrawingCanvasModel extends DefaultBindableModel {
    public enum UpdateType implements ModelUpdate {
        DATA;
    }
    public enum Mode {
        POINT, LINE;
    }
    private final List<Line2D> lines = Lists.newArrayList();
    private final List<Point2D> points = Lists.newArrayList();
    private Mode mode = Mode.POINT;
    private boolean allowDrag = true;
    private Point2D cursor;
    public void addLine(Line2D line) {
        lines.add(line);
        modelUpdated(UpdateType.DATA);
    }
    public List<Line2D> getLines() {
        return lines;
    }
    public void addPoint(Point2D point) {
        points.add(point);
        modelUpdated(UpdateType.DATA);
    }
    public List<Point2D> getPoints() {
        return points;
    }
    public void setMode(Mode mode) {
        setCursor(null);
        this.mode = mode;
        update();
    }
    public Mode getMode() {
        return mode;
    }
    public void clear() {
        lines.clear();
        points.clear();
        setCursor(null);
        modelUpdated(UpdateType.DATA);
    }
    public void setAllowDrag(boolean allowDrag) {
        this.allowDrag = allowDrag;
        update();
    }
    public boolean isAllowDrag() {
        return allowDrag;
    }
    public void setCursor(Point2D cursor) {
        this.cursor = cursor;
        update();
    }
    public Point2D getCursor() {
        return cursor;
    }
}