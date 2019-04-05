@BeanDefinition
public class TweakedPair extends Pair {
            
    public static TweakedPair.Meta meta() {
        return TweakedPair.Meta.INSTANCE;
    }
    static {
        JodaBeanUtils.registerMetaBean(TweakedPair.Meta.INSTANCE);
    }
    @Override
    public TweakedPair.Meta metaBean() {
        return TweakedPair.Meta.INSTANCE;
    }
    @Override
    protected Object propertyGet(String propertyName, boolean quiet) {
        return super.propertyGet(propertyName, quiet);
    }
    @Override
    protected void propertySet(String propertyName, Object newValue, boolean quiet) {
        super.propertySet(propertyName, newValue, quiet);
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == this.getClass()) {
            return super.equals(obj);
        }
        return false;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        return hash ^ super.hashCode();
    }
        
    public static class Meta extends Pair.Meta {
        
        static final Meta INSTANCE = new Meta();
        
        private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
            this, (DirectMetaPropertyMap) super.metaPropertyMap());
        
        protected Meta() {
        }
        @Override
        public BeanBuilder<? extends TweakedPair> builder() {
            return new DirectBeanBuilder<TweakedPair>(new TweakedPair());
        }
        @Override
        public Class<? extends TweakedPair> beanType() {
            return TweakedPair.class;
        }
        @Override
        public Map<String, MetaProperty<?>> metaPropertyMap() {
            return metaPropertyMap$;
        }
            }
        }