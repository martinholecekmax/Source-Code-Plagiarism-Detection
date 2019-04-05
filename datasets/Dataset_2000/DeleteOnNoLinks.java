public class DeleteOnNoLinks
  implements LifetimePolicy
  {
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder("DeleteOnNoLinks{");
        final int origLength = builder.length();
        builder.append('}');
        return builder.toString();
    }
  }