public interface FacetModel {
  
  @NotNull
  Facet[] getSortedFacets();
  
  @NotNull
  Facet[] getAllFacets();
  
  @NotNull
  <F extends Facet> Collection<F> getFacetsByType(FacetTypeId<F> typeId);
  
  @Nullable
  <F extends Facet> F getFacetByType(FacetTypeId<F> typeId);
  
  @Nullable
  <F extends Facet> F findFacet(FacetTypeId<F> type, String name);
  
  @Nullable
  <F extends Facet> F getFacetByType(@NotNull Facet underlyingFacet, FacetTypeId<F> typeId);
  
  @NotNull
  <F extends Facet> Collection<F> getFacetsByType(@NotNull Facet underlyingFacet, FacetTypeId<F> typeId);
  @NotNull
  String getFacetName(@NotNull Facet facet);
}