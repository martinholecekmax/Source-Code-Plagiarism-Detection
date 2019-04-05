public class StaticResourceLibrary implements ResourceLibrary {
    private final ImmutableList<ResourceKey> keys;
    public StaticResourceLibrary(ResourceKey[] keys) {
        super();
        this.keys = ImmutableList.copyOf(keys);
    }
    public Iterable<ResourceKey> getResources() {
        return keys;
    }
}