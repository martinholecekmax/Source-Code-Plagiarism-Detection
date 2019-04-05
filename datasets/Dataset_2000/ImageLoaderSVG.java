public class ImageLoaderSVG extends AbstractImageLoader {
    private ImageFlavor targetFlavor;
    
    public ImageLoaderSVG(ImageFlavor targetFlavor) {
        if (!(XMLNamespaceEnabledImageFlavor.SVG_DOM.isCompatible(targetFlavor))) {
            throw new IllegalArgumentException("Incompatible target ImageFlavor: " + targetFlavor);
        }
        this.targetFlavor = targetFlavor;
    }
    
    public ImageFlavor getTargetFlavor() {
        return this.targetFlavor;
    }
    
    public Image loadImage(ImageInfo info, Map hints, ImageSessionContext session)
                throws ImageException, IOException {
        if (!MimeConstants.MIME_SVG.equals(info.getMimeType())) {
            throw new IllegalArgumentException("ImageInfo must be from an SVG image");
        }
        Image img = info.getOriginalImage();
        if (!(img instanceof ImageXMLDOM)) {
            throw new IllegalArgumentException(
                    "ImageInfo was expected to contain the SVG document as DOM");
        }
        ImageXMLDOM svgImage = (ImageXMLDOM)img;
        if (!SVGDOMImplementation.SVG_NAMESPACE_URI.equals(svgImage.getRootNamespace())) {
            throw new IllegalArgumentException(
                    "The Image is not in the SVG namespace: " + svgImage.getRootNamespace());
        }
        return svgImage;
    }
}