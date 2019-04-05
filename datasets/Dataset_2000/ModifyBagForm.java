public class ModifyBagForm extends ActionForm
{
    protected String[] selectedBags;
    protected String newBagName;
    protected String pageName;
    protected String listsButton;
    
    public ModifyBagForm() {
        initialise();
    }
    
    public void initialise() {
        selectedBags = new String[0];
        newBagName = "";
    }
    
    public void setSelectedBags(String[] selectedBags) {
        this.selectedBags = selectedBags;
    }
    
    public String[] getSelectedBags() {
        return selectedBags;
    }
    
    public void setNewBagName(String name) {
        newBagName = name;
    }
    
    public String getNewBagName() {
        return newBagName;
    }
    
    public String getPageName() {
        return pageName;
    }
    
    public void setPageName(String pageName) {
        this.pageName = pageName;
    }
    
    public String getListsButton() {
        return listsButton;
    }
    
    public void setListsButton(String listsButton) {
        this.listsButton = listsButton;
    }
    
    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {
        initialise();
    }
}