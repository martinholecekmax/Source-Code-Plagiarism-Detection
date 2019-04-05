public class NewMethod implements TemplateMethodModelEx {
    public Object exec(List arguments) throws TemplateModelException {
        int size = arguments.size();
        if (size < 1) {
            throw new TemplateModelException(
                    "Invalid number of arguments for new(class, ...) method");
        }
        Class<?> klass;
        try {
            String className = (String)arguments.get(0);
            klass = Class.forName(className);
            if (size == 1) {
                return klass.newInstance();
            }
        } catch (Exception e) {
            throw new TemplateModelException("Failed to isntantiate the object", e);
        }
        arguments.remove(0);
        Object[] ar = arguments.toArray();
        size--;
        Constructor<?>[] ctors = klass.getConstructors();
        for (Constructor<?> ctor : ctors) {
            Class<?>[] params = ctor.getParameterTypes();             if (params.length == size) {                 try {
                    return ctor.newInstance(ar);
                } catch (Throwable e) {
                                    }
            }
        }
        throw new TemplateModelException("No suitable constructor found");
    }
}