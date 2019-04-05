public class DeleteGShadowLock implements Statement {
   @Override
   public Iterable<String> functionDependencies(OsFamily family) {
      return ImmutableList.of();
   }
   @Override
   public String render(OsFamily family) {
      if (checkNotNull(family, "family") == OsFamily.WINDOWS)
         throw new UnsupportedOperationException("windows not yet implemented");
      return "rm -f /etc/passwd.lock /etc/group.lock /etc/gshadow.lock";
   }
}