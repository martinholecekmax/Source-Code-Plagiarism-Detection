public class SetterInvoker extends SimpleMethodInvoker
{
   public SetterInvoker(Method method)
   {
      super(method);
   }
   @Override
   protected String getArgumentName(int index)
   {
      if (index == 0)
      {
         return "value";
      }
      else
      {
         throw new IndexOutOfBoundsException();
      }
   }
}