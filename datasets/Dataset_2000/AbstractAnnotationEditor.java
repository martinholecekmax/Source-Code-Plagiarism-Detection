public abstract class AbstractAnnotationEditor<A extends Annotation>
        implements AnnotationEditor<A> {
    private A annotation;
    private Class<A> c;
    private JComponent component;
    
    public final void setAnnotationClass(Class<A> c) {
        this.c = c;
    }
    public final Class<A> getAnnotationClass(){
        return this.c;
    }
    public AbstractAnnotationEditor() {
    }
    
    public void setAnnotation(A annotation) {
        this.annotation = annotation;
        setAnnotationClass((Class<A>) annotation.getClass());
    }
    
    public A newAnnotation() {
        return DefaultAnnotationFactory.getInstance().ofClass(c);
    }
    
    public abstract AbstractAnnotationEditor newInstance();
    @Override
    public JComponent getComponent() {
        if(component == null) {
            component = PanelFactory.createInfoPanel();
            component.setBorder(Borders.EMPTY_BORDER);
        }
        return component;
    }
}