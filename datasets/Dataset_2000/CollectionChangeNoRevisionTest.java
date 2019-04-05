public class CollectionChangeNoRevisionTest extends AbstractCollectionChangeTest {
    protected String getCollectionChangeValue() {
        return "false";
    }
    @Override
    protected List<Integer> getExpectedPersonRevisions() {
        return Arrays.asList(1);
    }
}