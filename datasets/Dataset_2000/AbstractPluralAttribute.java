public abstract class AbstractPluralAttribute<X, E, T> extends AbstractAttribute<X, E>
{
    private Class<T> collectionClazz;
    
    AbstractPluralAttribute(Type<E> attribType, String attribName,
            javax.persistence.metamodel.Attribute.PersistentAttributeType persistenceAttribType,
            ManagedType<X> managedType, Field member, Class<T> clazz)
    {
        super(attribType, attribName, persistenceAttribType, managedType, member);
        this.collectionClazz = clazz;
    }
    
    @Override
    public javax.persistence.metamodel.Bindable.BindableType getBindableType()
    {
        return BindableType.PLURAL_ATTRIBUTE;
    }
    
    @Override
    public boolean isCollection()
    {
        return true;
    }
    
    public abstract CollectionType getCollectionType();
    
    protected Class<T> getBoundJavaType()
    {
        return collectionClazz;
    }
}