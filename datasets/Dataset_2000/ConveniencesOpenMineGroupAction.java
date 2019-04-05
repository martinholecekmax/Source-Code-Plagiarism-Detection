@SuppressWarnings("serial")
public class ConveniencesOpenMineGroupAction extends ContextAwareAction {
    public static final String TEXT = "Open My Sandbox";
    private ActionContextImpl actionContext;
    public ConveniencesOpenMineGroupAction() {
        super(TEXT);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        AbstractComponent mineComponent = PlatformAccess.getPlatform().getMySandbox();
        mineComponent.open();
    }
    @Override
    public boolean canHandle(ActionContext context) {
        actionContext = (ActionContextImpl) context;
        if (actionContext.getTargetHousing() == null)
            return false;
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
}