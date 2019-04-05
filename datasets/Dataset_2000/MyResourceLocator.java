public class MyResourceLocator implements ResourceLocator {
    public URL getResourceURL(String key) {
        return TestFreemarkerRendering.class.getClassLoader().getResource(key);
    }
    public File getResourceFile(String key) {
        return null;
    }
}