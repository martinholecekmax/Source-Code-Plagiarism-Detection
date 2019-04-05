public class StandardJavaXMLDocumentProcessor implements DocumentProcessor {
    private final DocumentBuilder domBuilder;
    private final XPathFactory xPathFactory;
    public StandardJavaXMLDocumentProcessor()
            throws ParserConfigurationException {
        domBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        xPathFactory = XPathFactory.newInstance();
    }
    @Override
    public Object[] getNodes(Object node, String xpath)
            throws XPathEvaluationException {
        try {
            NodeList nodes = (NodeList) xPathFactory.newXPath().evaluate(xpath,
                    node, XPathConstants.NODESET);
            Object[] result = new Object[nodes.getLength()];
            for (int i = 0; i < result.length; i++) {
                result[i] = nodes.item(i);
            }
            return result;
        } catch (XPathExpressionException e) {
            throw new XPathEvaluationException(node, xpath, e);
        }
    }
    @Override
    public String getText(Object node, String xpath)
            throws XPathEvaluationException {
        try {
            return (String) xPathFactory.newXPath().evaluate(xpath, node,
                    XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            throw new XPathEvaluationException(node, xpath, e);
        }
    }
    @Override
    public Object parseDocument(String xmlText) throws Exception {
        return domBuilder.parse(new ByteArrayInputStream(xmlText.getBytes()));
    }
}