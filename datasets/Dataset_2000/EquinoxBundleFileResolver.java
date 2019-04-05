final class EquinoxBundleFileResolver implements BundleFileResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(EquinoxBundleFileResolver.class);
    @Override
    public File resolve(Bundle bundle) {
        BundleFile bundleFile = getBundleFile(bundle);
        if (bundleFile != null) {
            File file = bundleFile.getBaseFile();
            if (LOGGER.isDebugEnabled()) {
                LOGGER.debug("Resolved bundle '" + bundle.getSymbolicName() + "' to file '" + file.getAbsolutePath() + "'");
            }
            return file;
        }
        return null;
    }
    @Override
    public long resolveBundleEntrySize(Bundle bundle, String path) {
        BundleFile bundleFile = getBundleFile(bundle);
        if (bundleFile != null) {
            BundleEntry bundleEntry = bundleFile.getEntry(path);
            if (bundleEntry != null) {
                return bundleEntry.getSize();
            }
        }
        return -1L;
    }
    public static boolean canUse() {
        try {
            EquinoxBundleFileResolver.class.getClassLoader().loadClass(BundleHost.class.getName());
            return true;
        } catch (Exception _) {
            return false;
        } catch (LinkageError _) {
            return false;
        }
    }
    private BundleFile getBundleFile(Bundle bundle) {
        if (bundle instanceof BundleHost) {
            BundleHost bh = (BundleHost) bundle;
            BundleData bundleData = bh.getBundleData();
            if (bundleData instanceof BaseData) {
                return ((BaseData) bundleData).getBundleFile();
            }
        }
        return null;
    }
}