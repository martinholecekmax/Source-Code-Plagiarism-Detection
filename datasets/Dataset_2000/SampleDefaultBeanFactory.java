public class SampleDefaultBeanFactory extends BaseSampleBeanFactory {
  public Object createBean(Object srcObj, Class<?> srcObjClass, String id) {
    try {
      Class<?> destClass = Class.forName(id);
      Object rvalue = destClass.newInstance();
            setCreatedByFactoryName(rvalue, SampleDefaultBeanFactory.class.getName());
      return rvalue;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}