public interface ModelInferenceStrategy {
    public enum InferenceTask {
        COMMON, TABLEAU, CLASS_LATTICE_BUILD_AND_PRUNE, CLASS_LATTICE_PRUNE, PROPERTY_MATCH
    }
    public OntoModel buildModel( String name, OWLOntology ontoDescr, Map<InferenceTask, Resource> theory, StatefulKnowledgeSession kSession );
}