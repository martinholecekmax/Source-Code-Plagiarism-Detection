public interface IWizardPanel {
  public void show();
  public IWizardPanel getNextPanel();
  public IWizardPanel getPreviousPanel();
  public IWizardPanel getFinishPanel();
  public boolean isPreviousEnabled();
  public boolean isNextEnabled();
  public boolean isFinishEnabled();
  
  public boolean isFinishSelectionOK();
  public void finish();
}