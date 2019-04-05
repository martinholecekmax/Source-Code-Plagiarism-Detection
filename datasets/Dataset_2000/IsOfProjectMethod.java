public class IsOfProjectMethod implements TemplateMethodModelEx {
  final String currentProjectId;
  final Map<String, SchemaInfo> namespacesToSchemas;
  public IsOfProjectMethod(Map<String, SchemaInfo> namespacesToSchemas, String currentProjectId) {
    this.namespacesToSchemas = namespacesToSchemas;
    this.currentProjectId = currentProjectId;
  }
  @Override
  public Object exec(List list) throws TemplateModelException {
    if (list.size() < 1) {
      throw new TemplateModelException("The IsOfProjectMethod method must take something with a namespace and a project id as a parameter.");
    }
    Object object = BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(0));
    String ns;
    if (object instanceof SchemaInfo) {
      ns = ((SchemaInfo) object).getNamespace();
    }
    else if (object instanceof TypeDefinition) {
      ns = ((TypeDefinition) object).getNamespace();
    }
    else if (object instanceof RootElementDeclaration) {
      ns = ((RootElementDeclaration) object).getNamespace();
    }
    else if (object instanceof XmlType) {
      ns = ((XmlType) object).getNamespace();
    }
    else if (object instanceof Accessor) {
      ns = ((Accessor) object).getNamespace();
    }
    else {
      ns = String.valueOf(object);
    }
    SchemaInfo schemaInfo = this.namespacesToSchemas.get(ns);
    String projectId = list.size() > 1 ? String.valueOf(BeansWrapper.getDefaultInstance().unwrap((TemplateModel) list.get(1))) : this.currentProjectId;
    return isOfProject(schemaInfo, projectId);
  }
  public static boolean isOfProject(SchemaInfo schemaInfo, String projectId) {
    return (schemaInfo != null && projectId.equals(schemaInfo.getProperty("projectId")));
  }
}