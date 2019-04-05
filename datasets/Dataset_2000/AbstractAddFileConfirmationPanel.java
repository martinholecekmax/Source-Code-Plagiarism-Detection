public abstract class AbstractAddFileConfirmationPanel {
  protected final AddedFileInfo myAddedFileInfo;
  public static AbstractAddFileConfirmationPanel createOn(AddedFileInfo info){
    return info.getFile().isDirectory() ?
           new AddDirectoryConfirmationPanel(info) : new AddFileConfirmationPanel(info);
  }
  public AbstractAddFileConfirmationPanel(AddedFileInfo addedFileInfo) {
    myAddedFileInfo = addedFileInfo;
  }
  protected void init(){
    FileLabel fileLabel = getFileLabel();
    fileLabel.setShowIcon(false);
    fileLabel.setFile(myAddedFileInfo.getPresentableFile());
    fileLabel.pack();
  }
  protected abstract FileLabel getFileLabel();
  public abstract Component getPanel() ;
}