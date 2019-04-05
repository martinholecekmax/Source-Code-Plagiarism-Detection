public class FakeFox01BeanInfo extends SimpleBeanInfo {
    Class<FakeFox01> clazz = FakeFox01.class;
    String suffix = "." + clazz.getName();
    @Override
    public BeanDescriptor getBeanDescriptor() {
        BeanDescriptor beanDesc = new BeanDescriptor(clazz);
        beanDesc.setDisplayName(beanDesc.getDisplayName() + suffix);
        return beanDesc;
    }
    @Override
    public MethodDescriptor[] getMethodDescriptors() {
        Method get = null;
        Method set = null;
        try {
            get = clazz.getMethod("getFox01", (Class[]) null);
            set = clazz.getMethod("setFox01", new Class[] { String.class });
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        MethodDescriptor getDesc = new MethodDescriptor(get);
        getDesc.setDisplayName(getDesc.getDisplayName() + suffix);
        MethodDescriptor setDesc = new MethodDescriptor(set);
        setDesc.setDisplayName(setDesc.getDisplayName() + suffix);
        return new MethodDescriptor[] { setDesc, getDesc };
    }
    @Override
    public PropertyDescriptor[] getPropertyDescriptors() {
        PropertyDescriptor propertyDesc = null;
        try {
            propertyDesc = new PropertyDescriptor("fox01", clazz);
            propertyDesc.setDisplayName(propertyDesc.getDisplayName() + suffix);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return new PropertyDescriptor[] { propertyDesc };
    }
    
    @Override
    public int getDefaultEventIndex() {
        return -1;
    }
    
    @Override
    public int getDefaultPropertyIndex() {
                return 0;
    }
}