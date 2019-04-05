public final class ImageSupport {
    public static ImageDescriptor getImageDescriptor(String path) {
        URL url = BundleUtility.find(PlatformUI.PLUGIN_ID, path);
        return ImageDescriptor.createFromURL(url);
    }
    private ImageSupport() {
    }
}