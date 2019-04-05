public class BeginSegment extends CGMTag {
    private int name;
    public BeginSegment() {
        super(0, 6, 2);
    }
    public BeginSegment(int name) {
        this();
        this.name = name;
    }
    public void write(int tagID, CGMOutputStream cgm) throws IOException {
        cgm.writeName(name);
    }
    public void write(int tagID, CGMWriter cgm) throws IOException {
        cgm.print("BEGSEG ");
        cgm.writeName(name);
        cgm.indent();
    }
}