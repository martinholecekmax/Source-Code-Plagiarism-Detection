public final class CdiContainerLoader
{
    private static CdiContainer cdiContainer = null;
    private CdiContainerLoader()
    {
            }
    
    public static synchronized CdiContainer getCdiContainer()
    {
        if (cdiContainer == null)
        {
                        ServiceLoader<CdiContainer> cdiContainerLoader = ServiceLoader.load(CdiContainer.class);
            Iterator<CdiContainer> cdiIt = cdiContainerLoader.iterator();
            if (cdiIt.hasNext())
            {
                cdiContainer = cdiIt.next();
            }
            else
            {
                throw new IllegalStateException("Could not find an implementation of " + CdiContainer.class.getName() +
                    " available in the classpath!");
            }
            if (cdiIt.hasNext())
            {
                String foundContainers = getContainerDetails();
                throw new IllegalStateException("Too many implementations of " + CdiContainer.class.getName() +
                    " found in the classpath! Details: " + foundContainers);
            }
        }
        return cdiContainer;
    }
    private static String getContainerDetails()
    {
        StringBuilder result = new StringBuilder();
        Class containerClass;
        for (CdiContainer cdiContainer : ServiceLoader.load(CdiContainer.class))
        {
            containerClass = cdiContainer.getClass();
            result.append(containerClass.getProtectionDomain().getCodeSource().getLocation().toExternalForm());
            result.append(containerClass.getName());
            result.append(System.getProperty("line.separator"));
        }
        return result.toString();
    }
}