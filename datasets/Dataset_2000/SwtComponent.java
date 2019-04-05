public final class SwtComponent extends AUTComponent {
    
    public SwtComponent(Widget component) {
        super(component);
    }
    
    public Widget getRealComponent() {
        return (Widget)getComp();
    }
}