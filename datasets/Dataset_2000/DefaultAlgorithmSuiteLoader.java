public class DefaultAlgorithmSuiteLoader implements AlgorithmSuiteLoader {
    private static final String CXF_CUSTOM_POLICY_NS = 
         "http:    public AlgorithmSuite getAlgorithmSuite(Element policyElement, SPConstants consts) {
        if (policyElement != null) {
            Element algorithm = DOMUtils.getFirstElement(policyElement);
            if (algorithm != null) {
                AlgorithmSuite algorithmSuite = null;
                if (CXF_CUSTOM_POLICY_NS.equals(algorithm.getNamespaceURI())) {
                    algorithmSuite = new GCMAlgorithmSuite(consts);
                } else {
                    algorithmSuite = new AlgorithmSuite(consts);
                }
                algorithmSuite.setAlgorithmSuite(algorithm.getLocalName());
                return algorithmSuite;
            }
        }
        return null;
    }
}