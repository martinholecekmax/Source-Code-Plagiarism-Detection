public class OrConstraintTest extends AbstractQOMTest {
    public void testOr() throws RepositoryException {
        Node n1 = testRootNode.addNode(nodeName1, testNodeType);
        n1.setProperty(propertyName1, "foo");
        Node n2 = testRootNode.addNode(nodeName2, testNodeType);
        n2.setProperty(propertyName2, "bar");
        superuser.save();
        QueryObjectModel qom = qf.createQuery(
                qf.selector(testNodeType, "s"),
                qf.and(
                        qf.descendantNode("s", testRootNode.getPath()),
                        qf.or(
                                qf.propertyExistence("s", propertyName1),
                                qf.propertyExistence("s", propertyName2)
                        )
                ),
                null,
                null
        );
        checkQOM(qom, new Node[]{n1, n2});
    }
}