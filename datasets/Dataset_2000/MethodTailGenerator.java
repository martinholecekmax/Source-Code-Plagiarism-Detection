@Module
public class MethodTailGenerator<X> extends NullGenerator<X> {
  protected final MethodTailFactory<X> _factory;
  protected final AnnotatedMethod<? super X> _method;
  public MethodTailGenerator(MethodTailFactory<X> factory,
                             AnnotatedMethod<? super X> method)
  {
    _factory = factory;
    _method = method;
  }
  
  @Override
  public void generateCall(JavaWriter out)
    throws IOException
  {
    String superVar = _factory.getAspectBeanFactory().getBeanSuper();
    out.println();
    Method javaImplMethod = _method.getJavaMember();
    if (! void.class.equals(javaImplMethod.getReturnType())) {
      out.print("result = ");
    }
    out.print(superVar + "." + javaImplMethod.getName() + "(");
    Class<?>[] types = javaImplMethod.getParameterTypes();
    for (int i = 0; i < types.length; i++) {
      if (i != 0)
        out.print(", ");
      out.print(" a" + i);
    }
    out.println(");");
    
  }
}