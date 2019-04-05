public class ArquillianContextResolver extends BaseContextualResolver implements ContextualResolver
{
            
   private final ArquillianContext delegate;
            
   public ArquillianContextResolver(final ArquillianContext delegate) throws IllegalArgumentException
   {
            if (delegate == null)
      {
         throw new IllegalArgumentException("delegate must be specified");
      }
      this.delegate = delegate;
   }
            
   @Override
   public <T> T resolve(final Class<T> type, final Map<String, Object> properties) throws IllegalArgumentException
   {
            if (ArquillianContext.class.isAssignableFrom(type))
      {
         return type.cast(delegate);
      }
            return null;
   }
}