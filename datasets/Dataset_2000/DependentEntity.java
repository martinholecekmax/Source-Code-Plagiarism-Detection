public interface DependentEntity {
  @Deprecated
  public boolean isStale(IFile staleFile, Set<Location> staleLocations);
  public boolean isStale(IndexableSource staleSource, Set<Location> staleLocations);
  public String toString(boolean showLayers);
}