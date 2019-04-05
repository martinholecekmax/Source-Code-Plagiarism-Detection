public class WebAppDescriptorImpl extends NodeDescriptorImplBase implements WebAppDescriptor
{
                     private final Node model;
            public WebAppDescriptorImpl(String descriptorName)
   {
      this(descriptorName, new Node("web-app")
            .attribute("xmlns", "http:            .attribute("xmlns:xsi", "http:            .attribute("xsi:schemaLocation",
                  "http:      version("3.0");
   }
   public WebAppDescriptorImpl(String descriptorName, Node model)
   {
      super(descriptorName);
      this.model = model;
   }
            @Override
   public WebAppDescriptor version(final String version)
   {
      if (version == null || version.length() == 0)
      {
         throw new IllegalArgumentException("Version must be specified");
      }
      model.attribute("xsi:schemaLocation",
            "http:                  + ".xsd");
      model.attribute("version", version);
      return this;
   }
   @Override
   public WebAppDescriptor displayName(String displayName)
   {
      model.getOrCreate("display-name").text(displayName);
      return this;
   }
   @Override
   public ServletDef servlet(String clazz, String... urlPatterns)
   {
      return servlet(getSimpleName(clazz), clazz, urlPatterns);
   }
   @Override
   public ServletDef servlet(String name, String clazz, String[] urlPatterns)
   {
      Node servletNode = model.createChild("servlet");
      servletNode.createChild("servlet-name").text(name);
      servletNode.createChild("servlet-class").text(clazz);
      ServletDef servlet = new ServletDefImpl(getDescriptorName(), model, servletNode);
      servlet.mapping().urlPatterns(urlPatterns);
      return servlet;
   }
   
   @Override
   public Node getRootNode()
   {
      return model;
   }
            
   private String getSimpleName(String fqcn)
   {
      if (fqcn.indexOf('.') >= 0)
      {
         return fqcn.substring(fqcn.lastIndexOf('.') + 1);
      }
      return fqcn;
   }
}