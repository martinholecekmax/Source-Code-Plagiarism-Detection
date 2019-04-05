public class DartProjectInfo extends OpenableElementInfo {
  
  private List<String> childPaths = null;
  
  private HashMap<String, List<String>> htmlMapping;
  
  public List<String> getChildPaths() {
    return childPaths;
  }
  
  public HashMap<String, List<String>> getHtmlMapping() {
    return htmlMapping;
  }
  public DartLibraryImpl[] getLibraries() {
    ArrayList<DartLibraryImpl> libraries = new ArrayList<DartLibraryImpl>();
    for (DartElement child : getChildren()) {
      if (child instanceof DartLibraryImpl) {
        libraries.add((DartLibraryImpl) child);
      }
    }
    return libraries.toArray(new DartLibraryImpl[libraries.size()]);
  }
  public IResource[] getNonDartResources(DartProjectImpl project) {
    DartCore.notYetImplemented();
    return new IResource[0];
  }
  public void resetCaches() {
    DartCore.notYetImplemented();
  }
  
  public void setChildPaths(List<String> paths) {
    childPaths = paths;
  }
  
  public void setHtmlMapping(HashMap<String, List<String>> mapping) {
    htmlMapping = mapping;
  }
  
  public void updateHtmlMapping(String htmlFileName, List<String> libraries, boolean add) {
    if (htmlMapping == null) {
      return;
    }
    if (add) {
      htmlMapping.put(htmlFileName, libraries);
    } else {
      htmlMapping.remove(htmlFileName);
    }
  }
}