public abstract class AbstractXMLWritingIFDocumentHandler extends AbstractIFDocumentHandler {
    
    protected SAXTransformerFactory tFactory
        = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
    
    protected GenerationHelperContentHandler handler;
    protected AbstractXMLWritingIFDocumentHandler(IFContext context) {
        super(context);
    }
    
    public void setResult(Result result) throws IFException {
        if (result instanceof SAXResult) {
            SAXResult saxResult = (SAXResult)result;
            this.handler = new GenerationHelperContentHandler(
                    saxResult.getHandler(), getMainNamespace());
        } else {
            this.handler = new GenerationHelperContentHandler(
                    createContentHandler(result), getMainNamespace());
        }
    }
    
    protected abstract String getMainNamespace();
    
    protected ContentHandler createContentHandler(Result result) throws IFException {
        try {
            TransformerHandler tHandler = tFactory.newTransformerHandler();
            Transformer transformer = tHandler.getTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            tHandler.setResult(result);
            return tHandler;
        } catch (TransformerConfigurationException tce) {
            throw new IFException(
                    "Error while setting up the serializer for XML output", tce);
        }
    }
}