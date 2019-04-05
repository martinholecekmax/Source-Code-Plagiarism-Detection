public class DelegatePackageCache extends AbstractChangeAwareCache<DelegateTemplateCache> {
    @NonNls
    public static final String DEFAULT_DELEGATE = "\u001a [del]";
    private static final Key<DelegatePackageCache> DELEGATE_CACHE_KEY = new Key<DelegatePackageCache>("non-dairy.delegate-cache");
    private final Module module;
    public DelegatePackageCache(@NotNull Module module) {
        this.module = module;
    }
    @NotNull
    @Override
    protected DelegateTemplateCache create(String delegate) {
        return new DelegateTemplateCache(this, delegate);
    }
    @NotNull
    public Module getModule() {
        return module;
    }
    @Override
    @Nullable
    public String getKeyFor(@NotNull DelegateTemplateCache value) {
        return value.getDelegatePackage();
    }
    @NotNull
    public static DelegatePackageCache getCache(@NotNull Module module) {
        DelegatePackageCache cache = module.getUserData(DELEGATE_CACHE_KEY);
        if (cache == null) {
            cache = new DelegatePackageCache(module);
            module.putUserData(DELEGATE_CACHE_KEY, cache);
        }
        return cache;
    }
}