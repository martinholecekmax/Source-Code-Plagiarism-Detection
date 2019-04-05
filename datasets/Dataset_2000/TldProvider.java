public interface TldProvider {
    Collection<TldEntry> getTlds();
    public class TldEntry {
        private URL url;
        private Bundle bundle;
        private URL jarUrl;
        private String name;
        public TldEntry(Bundle bundle, URL url) {
            this(bundle, url, null);
        }
        public TldEntry(Bundle bundle, URL url, URL jarUrl) {
            this.bundle = bundle;
            this.url = url;            
            this.jarUrl = jarUrl;
            String path = url.getPath();
            if (path.startsWith("/")) {
                name = path.substring(1);
            } else {
                name = path;
            }
        }
        public URL getURL() {
            return url;
        }
        public Bundle getBundle() {
            return bundle;
        }
        public URL getJarUrl() {
            return jarUrl;
        }
        public String getName() {
            return name;
        }
    }
}