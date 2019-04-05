public class LineSetOffsetState extends GraphicSetOffsetState {
    public LineSetOffsetState(EditableOMLine eoml) {
        super(eoml);
    }
    protected void setGrabPoint(MouseEvent e) {
        OffsetGrabPoint ogb = (OffsetGrabPoint) graphic.getGrabPoint(EditableOMLine.OFFSET_POINT_INDEX);
        ogb.set(e.getX(), e.getY());
        ogb.updateOffsets();
        graphic.setMovingPoint(graphic.getGrabPoint(EditableOMLine.OFFSET_POINT_INDEX));
        graphic.redraw(e);
        graphic.fireEvent(EOMGCursors.PUTNODE,
                i18n.get(LineSetOffsetState.class,
                        "Click_to_place_offset_point_for_line.",
                        "Click to place offset point for line."), EOMGEvent.EOMG_UNCHANGED);
    }
}