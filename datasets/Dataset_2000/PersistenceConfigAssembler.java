public class PersistenceConfigAssembler
    implements Assembler
{
    public void assemble( ModuleAssembly module )
        throws AssemblyException
    {
        module.services(
            UuidIdentityGeneratorService.class,
            MemoryEntityStoreService.class
        ).visibleIn( layer ).instantiateOnStartup();
    }
}