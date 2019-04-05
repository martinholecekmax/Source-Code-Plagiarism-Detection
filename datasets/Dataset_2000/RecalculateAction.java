public class RecalculateAction extends AbstractAction {
    private static final Log LOGGER = LogFactory.getLog(RecalculateAction.class);
    
    public RecalculateAction(Element element, Model model) {
        super(element, model);
    }
        
    public void perform() throws XFormsException {
                this.model.recalculate();
                doRecalculate(false);
    }
    
    protected Log getLogger() {
        return LOGGER;
    }
}