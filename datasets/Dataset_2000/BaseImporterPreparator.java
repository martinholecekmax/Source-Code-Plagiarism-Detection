public abstract class BaseImporterPreparator<T extends ImporterDescription>
        implements ImporterPreparator<T> {
    
    @SuppressWarnings("unchecked")
    @Override
    public Class<T> getDescriptionClass() {
        List<Type> arguments = TypeUtil.invoke(BaseImporterPreparator.class, getClass());
        if (arguments.size() != 1) {
            throw new IllegalStateException(MessageFormat.format(
                    "Failed to extract type argument from {0}",
                    getClass().getName()));
        }
        Type first = arguments.get(0);
        if ((first instanceof Class<?>) == false
                || ImporterDescription.class.isAssignableFrom((Class<?>) first) == false) {
            throw new IllegalStateException(MessageFormat.format(
                    "Failed to extract type argument of {0} from {1}",
                    ImporterDescription.class.getName(),
                    getClass().getName()));
        }
        return (Class<T>) first;
    }
}