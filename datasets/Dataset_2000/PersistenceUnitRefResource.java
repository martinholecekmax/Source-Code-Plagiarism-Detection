public class PersistenceUnitRefResource implements Resource
{
   private final String puSupplier;
   public PersistenceUnitRefResource(String puSupplier)
   {
      if (puSupplier == null)
      {
         throw new IllegalArgumentException("Cannot create a PersistenceUnitRefResource for a null persistence unit supplier");
      }
      this.puSupplier = puSupplier;
   }
   @Override
   public Object getDependency()
   {
                  return puSupplier;
   }
   @Override
   public Object getTarget()
   {
      ManagedEntityManagerFactory managedEntityManagerFactory = ((PersistenceUnitDeployment)PersistenceUnitRegistry.getPersistenceUnit(puSupplier)).getManagedFactory();
      return managedEntityManagerFactory.getEntityManagerFactory();
   }
   @Override
   public String toString()
   {
      return PersistenceUnitRefResource.class.getSimpleName() + "[supplier=" + this.puSupplier + "]";
   }
   @Override
   public Collection<?> getInvocationDependencies()
   {
      return null;
   }
}