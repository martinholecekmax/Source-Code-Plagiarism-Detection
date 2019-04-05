public class FunctionalPropertyImpl
    extends OntPropertyImpl
    implements FunctionalProperty
{
                    
    @SuppressWarnings("hiding")
    public static Implementation factory = new Implementation() {
        @Override
        public EnhNode wrap( Node n, EnhGraph eg ) {
            if (canWrap( n, eg )) {
                return new FunctionalPropertyImpl( n, eg );
            }
            else {
                throw new ConversionException( "Cannot convert node " + n + " to FunctionalProperty");
            }
        }
        @Override
        public boolean canWrap( Node node, EnhGraph eg ) {
                        Profile profile = (eg instanceof OntModel) ? ((OntModel) eg).getProfile() : null;
            return (profile != null)  &&  profile.isSupported( node, eg, FunctionalProperty.class );
        }
    };
                    
    public FunctionalPropertyImpl( Node n, EnhGraph g ) {
        super( n, g );
    }
                            }