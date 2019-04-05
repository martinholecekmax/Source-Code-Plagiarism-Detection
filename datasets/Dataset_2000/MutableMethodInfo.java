public interface MutableMethodInfo extends MethodInfo
{
   
   void setModifier(ModifierInfo mi);
   
   void setReturnType(String returnType);
   
   void setReturnType(ClassInfo returnType);
   
   void setName(String name);
   
   void setBody(Body body);
   
   void setParameters(String[] parameters);
   
   void setParameters(ClassInfo[] parameters);
   
   void setExceptions(String[] exceptions);
   
   void setExceptions(ClassInfo[] exceptions);
   
   void executeCommand(MutableMethodInfoCommand mmc);
}