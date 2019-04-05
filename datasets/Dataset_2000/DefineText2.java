public class DefineText2 extends DefineText {
    public DefineText2(int id, Rectangle2D bounds, AffineTransform matrix,
            Vector<Record> text) {
        this();
        character = id;
        this.bounds = bounds;
        this.matrix = matrix;
        this.text = text;
    }
    public DefineText2() {
        super(33, 3);
    }
    public SWFTag read(int tagID, SWFInputStream swf, int len)
            throws IOException {
        DefineText2 tag = new DefineText2();
        tag.read(tagID, swf, len, true);
        return tag;
    }
    public void write(int tagID, SWFOutputStream swf) throws IOException {
        write(swf, true);
    }
}