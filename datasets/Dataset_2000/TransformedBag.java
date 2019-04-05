public class TransformedBag extends TransformedCollection implements Bag {
    
    private static final long serialVersionUID = 5421170911299074185L;
    
    public static <I,O> Bag<O> decorate(Bag<I> bag, Transformer<? super I, ? extends O> transformer) {
        return new TransformedBag(bag, transformer);
    }
        
    protected TransformedBag(Bag bag, Transformer transformer) {
        super(bag, transformer);
    }
    
    protected Bag getBag() {
        return (Bag) collection;
    }
        public int getCount(Object object) {
        return getBag().getCount(object);
    }
    public boolean remove(Object object, int nCopies) {
        return getBag().remove(object, nCopies);
    }
        public boolean add(Object object, int nCopies) {
        object = transform(object);
        return getBag().add(object, nCopies);
    }
    public Set uniqueSet() {
        Set set = getBag().uniqueSet();
        return TransformedSet.decorate(set, transformer);
    }
}