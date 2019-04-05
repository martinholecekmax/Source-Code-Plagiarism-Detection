public class BundleFunctionLoader implements FunctionLoader {
   private final BundleContext bundleContext;
   private ServiceRegistration registration;
   
   public BundleFunctionLoader(BundleContext bundleContext) {
      this.bundleContext = bundleContext;
   }
   
   public void start() {
      Bundle bundle = bundleContext.getBundle();
      Enumeration<?> entries = bundle.findEntries("/functions/", "*.*", false);
      StringBuilder sb = new StringBuilder();
      while (entries.hasMoreElements()) {
         URL url = (URL) entries.nextElement();
         String function = url.getFile();
         sb.append(function);
         if (entries.hasMoreElements()) {
            sb.append(" ");
         }
      }
      String functions = sb.toString();
      registerFunction(functions);
   }
   
   public void stop() {
      registration.unregister();
   }
   
   @Override
   public String loadFunction(String function, OsFamily family) throws FunctionNotFoundException {
      try {
         return Resources.toString(bundleContext.getBundle().getResource(
                  String.format("/functions/%s.%s", function, ShellToken.SH.to(family))), Charsets.UTF_8);
      } catch (IOException e) {
         throw new FunctionNotFoundException(function, family, e);
      }
   }
   private void registerFunction(String functions) {
      Properties properties = new Properties();
      properties.put("function", functions);
      registration = bundleContext.registerService(FunctionLoader.class.getName(), this, properties);
   }
}