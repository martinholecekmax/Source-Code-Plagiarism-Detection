public class JpsLibraryReferenceImpl extends JpsNamedElementReferenceImpl<JpsLibrary, JpsLibraryReferenceImpl> implements JpsLibraryReference {
  public JpsLibraryReferenceImpl(String elementName, JpsElementReference<? extends JpsCompositeElement> parentReference) {
    super(JpsLibraryRole.LIBRARIES_COLLECTION_ROLE, elementName, parentReference);
  }
  private JpsLibraryReferenceImpl(JpsLibraryReferenceImpl original) {
    super(original);
  }
  @NotNull
  @Override
  public String getLibraryName() {
    return myElementName;
  }
  @NotNull
  @Override
  public JpsLibraryReferenceImpl createCopy() {
    return new JpsLibraryReferenceImpl(this);
  }
  @Override
  public JpsLibraryReference asExternal(@NotNull JpsModel model) {
    model.registerExternalReference(this);
    return this;
  }
}