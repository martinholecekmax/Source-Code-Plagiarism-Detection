public class RemoteCurrencyMatrixSource extends AbstractRemoteClient implements CurrencyMatrixSource {
  
  public RemoteCurrencyMatrixSource(final URI baseUri) {
    super(baseUri);
  }
    @Override
  public CurrencyMatrix getCurrencyMatrix(String name) {
    ArgumentChecker.notNull(name, "name");
    try {
      URI uri = DataCurrencyMatrixSourceResource.uriGetMatrix(getBaseUri(), name);
      return accessRemote(uri).get(CurrencyMatrix.class);
    } catch (DataNotFoundException ex) {
      return null;
    } catch (UniformInterfaceException404NotFound ex) {
      return null;
    }
  }
}