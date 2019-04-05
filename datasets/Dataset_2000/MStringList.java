public class MStringList {
  private List<String> internalList;
  
  public MStringList(List<String> list) {
    this.internalList = list;
  }
  
  public List<String> getInternalList() {
    return internalList;
  }
  
  public void setInternalList(List<String> internalList) {
    this.internalList = internalList;
  }
  
  @Override
  public String toString() {
    return  internalList.toString();
  }
}