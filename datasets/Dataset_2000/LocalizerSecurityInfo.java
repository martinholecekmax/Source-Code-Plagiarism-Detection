public class LocalizerSecurityInfo extends SecurityInfo {
  private static final Log LOG = LogFactory.getLog(LocalizerSecurityInfo.class);
  @Override
  public KerberosInfo getKerberosInfo(Class<?> protocol, Configuration conf) {
    return null;
  }
  @Override
  public TokenInfo getTokenInfo(Class<?> protocol, Configuration conf) {
    if (!protocol
        .equals(LocalizationProtocolPB.class)) {
      return null;
    }
    return new TokenInfo() {
      @Override
      public Class<? extends Annotation> annotationType() {
        return null;
      }
      @Override
      public Class<? extends TokenSelector<? extends TokenIdentifier>>
          value() {
        LOG.debug("Using localizerTokenSecurityInfo");
        return LocalizerTokenSelector.class;
      }
    };
  }
}