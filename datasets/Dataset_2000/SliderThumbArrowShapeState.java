class SliderThumbArrowShapeState extends State {
    SliderThumbArrowShapeState() {
        super("ArrowShape");
    }
    @Override protected boolean isInState(JComponent c) {
 return c.getClientProperty("Slider.paintThumbArrowShape") == Boolean.TRUE; 
    }
}