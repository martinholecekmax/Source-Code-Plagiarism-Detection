public class ToolBarIOReadInfo {
  List notInstalledToolBarList;
  List installedToolBarList = new ArrayList();
  List unknownToolBarNames = new ArrayList();
  List registeredToolbars;
  public ToolBarIOReadInfo() {
  }
  
  public List getInstalledToolbars(){
    return installedToolBarList;
  }
  
  public List getNotInstalledToolbars(){
    return notInstalledToolBarList;
  }
  
  public List getUnknownToolbarNames(){
    return unknownToolBarNames;
  }
  void notifyToolbarInstalled(VLToolBar tb){
    installedToolBarList.add(tb);
  }
  void setRegisteredToolbars(List registered) {
    this.registeredToolbars = registered;
  }
  
  void finishLoading(){
    this.notInstalledToolBarList = new ArrayList(registeredToolbars);
    notInstalledToolBarList.removeAll(installedToolBarList);
  }
  void notifyUnknownToolbarFound(String toolbarName) {
    unknownToolBarNames.add(toolbarName);
  }
}