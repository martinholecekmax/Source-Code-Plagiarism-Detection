public interface IComponentGenerator
{
   
   UIComponent generate(FacesContext context, String id);
   
   UIComponent generateAndAdd(FacesContext context, UIPropertySheet propertySheet, 
         PropertySheetItem item);
   
   boolean isEnabledInEditMode (FacesContext context, UIComponent control, PropertyDefinition propDef);
}