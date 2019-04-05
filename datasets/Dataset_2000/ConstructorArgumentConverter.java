public class ConstructorArgumentConverter<F, T> implements Converter<F, T> {
    private Constructor<T> constructor;
    private final List<ArgumentConverter<F, Object>> argumentConverters = new LinkedList<ArgumentConverter<F, Object>>();
    public ConstructorArgumentConverter(Class<T> clazz, Object... arguments) {
        for (Constructor<?> c : clazz.getConstructors()) {
            if (isCompatible(c, arguments)) {
                this.constructor = (Constructor<T>)c;
                break;
            }
        }
        if (constructor == null)
            throw new IntrospectionException("Unable to find a constructor of " + clazz.getName() + " compatible with the given arguments");
        if (arguments != null)
            for (Object argument : arguments) { argumentConverters.add(new ArgumentConverter<F, Object>(argument)); }
    }
    private boolean isCompatible(Constructor<?> constructor, Object... arguments) {
        try {
            constructor.newInstance(arguments);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public T convert(F from) {
        Object[] initArgs = new Object[argumentConverters.size()];
        int i = 0;
        for (ArgumentConverter<F, Object> argumentConverter : argumentConverters) {
            initArgs[i++] = argumentConverter.convert(from);
        }
        try {
            return constructor.newInstance(initArgs);
        } catch (Exception e) {
            throw new IntrospectionException("Unable to create an object of class " + constructor.getDeclaringClass().getName(), e);
        }
    }
}