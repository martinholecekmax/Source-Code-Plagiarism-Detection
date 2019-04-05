public class DefaultUriResolver implements UriResolver {
    private static final String NUXEO_ANNOTATIONS = "nuxeo/Annotations/";
    public String getBaseUrl(URI uri) {
        if (uri == null) {
            return null;
        }
        try {
            String url = uri.toURL().toString();
            if (url.contains(NUXEO_ANNOTATIONS)) {
                return url.substring(0, url.indexOf(NUXEO_ANNOTATIONS)
                        + NUXEO_ANNOTATIONS.length());
            } else {
                return url.substring(0, url.indexOf("nuxeo") + "nuxeo".length());
            }
        } catch (MalformedURLException e) {
            return null;         }
    }
    public List<URI> getSearchURI(URI uri) throws AnnotationException {
        return Collections.singletonList(uri);
    }
    public URI translateFromGraphURI(URI uri, String baseUrl)
            throws AnnotationException {
        if (uri.toString().startsWith("urn:annotation:")) {
            String annId = uri.toString().substring(
                    uri.toString().lastIndexOf(":") + 1);
            try {
                return new URI(baseUrl + annId);
            } catch (URISyntaxException e) {
                throw new AnnotationException(e);
            }
        }
        return uri;
    }
    public URI translateToGraphURI(URI uri) throws AnnotationException {
        String path = uri.getPath();
        if (uri.toString().contains(NUXEO_ANNOTATIONS)) {
            try {
                return new URI("urn:annotation:"
                        + path.substring(path.lastIndexOf("/") + 1));
            } catch (URISyntaxException e) {
                throw new AnnotationException(e);
            }
        } else {
            return uri;
        }
    }
}