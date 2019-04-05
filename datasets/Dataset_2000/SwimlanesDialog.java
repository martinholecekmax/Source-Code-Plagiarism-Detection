public class SwimlanesDialog extends EditListDialog<Swimlane> {
    protected SwimlanesDialog(Shell parentShell) {
        super(parentShell, "Swimlanes", SwimlaneDialog.class);
    }
    protected Swimlane createItem() {
        return new Swimlane();
    }
}