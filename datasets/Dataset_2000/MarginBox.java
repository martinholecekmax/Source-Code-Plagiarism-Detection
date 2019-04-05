public class MarginBox extends BlockBox {
    private Rectangle _bounds;
    public MarginBox(Rectangle bounds) {
        _bounds = bounds;
    }
    public int getWidth() {
        return _bounds.width;
    }
    public int getHeight() {
        return _bounds.height;
    }
    public int getContentWidth() {
        return _bounds.width;
    }
    public Rectangle getContentAreaEdge(int left, int top, CssContext cssCtx) {
        return new Rectangle(-_bounds.x, -_bounds.y, _bounds.width, _bounds.height);
    }
    public Rectangle getPaddingEdge(int left, int top, CssContext cssCtx) {
        return new Rectangle(-_bounds.x, -_bounds.y, _bounds.width, _bounds.height);
    }
    protected int getContainingBlockWidth() {
        return _bounds.width;
    }
    protected int getPaddingWidth(CssContext cssCtx) {
        return _bounds.width;
    }
    public BlockBox copyOf() {
        throw new IllegalArgumentException("cannot be copied");
    }    
}