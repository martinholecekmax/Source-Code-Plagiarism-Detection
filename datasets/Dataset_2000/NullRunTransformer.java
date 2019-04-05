public class NullRunTransformer implements RunTransformer {
    public static final Logger LOG = Logger.getLogger(NullRunTransformer.class);
    public NullRunTransformer(final RunTransformerConfig config) {}
    public Collection<SearchConfiguration> transform(final Context context){
        LOG.debug("NullRunTransformer");
        return context.getApplicableSearchConfigurations();
    }
}