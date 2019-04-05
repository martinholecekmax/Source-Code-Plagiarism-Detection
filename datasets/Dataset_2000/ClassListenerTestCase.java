public class ClassListenerTestCase extends AbstractJenaTestCase {
    private int eventCount = 0;
    private ClassListener listener = new ClassAdapter() {
        public void addedToUnionDomainOf(RDFSClass cls, RDFProperty property) {
            eventCount++;
        }
        public void instanceAdded(RDFSClass cls, RDFResource instance) {
            eventCount++;
        }
        public void instanceRemoved(RDFSClass cls, RDFResource instance) {
            eventCount++;
        }
        public void removedFromUnionDomainOf(RDFSClass cls, RDFProperty property) {
            eventCount++;
        }
        public void subclassAdded(RDFSClass cls, RDFSClass subclass) {
            eventCount++;
        }
        public void subclassRemoved(RDFSClass cls, RDFSClass subclass) {
            eventCount++;
        }
        public void superclassAdded(RDFSClass cls, RDFSClass superclass) {
            eventCount++;
        }
        public void superclassRemoved(RDFSClass cls, RDFSClass superclass) {
            eventCount++;
        }
    };
    public void testEventCount() {
        RDFSClass cls = owlModel.createRDFSNamedClass("Class");
        RDFSClass subclass = owlModel.createRDFSNamedClass("Subclass");
        cls.addClassListener(listener);
        subclass.addClassListener(listener);
        assertEquals(0, eventCount);
        subclass.addSuperclass(cls);
        assertEquals(2, eventCount);
        subclass.removeSuperclass(cls);
        assertEquals(4, eventCount);
        Instance instance = cls.createInstance("instance");
        assertEquals(5, eventCount);
        instance.delete();
        assertEquals(6, eventCount);
        RDFProperty property = owlModel.createRDFProperty("property");
        property.setDomain(cls);
        assertEquals(11, eventCount);
        property.removeUnionDomainClass(cls);
        assertEquals(14, eventCount);
    }
}