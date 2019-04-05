public class SLDLabelPlacementBinding extends AbstractComplexBinding {
    StyleFactory styleFactory;
    public SLDLabelPlacementBinding(StyleFactory styleFactory) {
        this.styleFactory = styleFactory;
    }
    
    public QName getTarget() {
        return SLD.LABELPLACEMENT;
    }
    
    public int getExecutionMode() {
        return AFTER;
    }
    
    public Class getType() {
        return LabelPlacement.class;
    }
    
    public void initialize(ElementInstance instance, Node node, MutablePicoContainer context) {
    }
    
    public Object parse(ElementInstance instance, Node node, Object value)
        throws Exception {
                                        return node.getChildValue(LabelPlacement.class);
    }
}