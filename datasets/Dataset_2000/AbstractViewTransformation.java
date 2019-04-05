public class AbstractViewTransformation<K, V, S, T> implements View<K, V, S, T> {
    public V storeToView(Store<K, S, T> store, K k, S s, T t) {
        throw new UnsupportedViewOperationException("Read attempt on write-only view!");
    }
    public S viewToStore(Store<K, S, T> store, K k, V v, T t) {
        throw new UnsupportedViewOperationException("Write attempt on read-only view!");
    }
}