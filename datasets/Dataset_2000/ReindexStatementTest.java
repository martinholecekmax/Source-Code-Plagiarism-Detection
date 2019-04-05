public class ReindexStatementTest extends AbstractSqStatementTest<ReindexStatement> {
    @Override
    protected ReindexStatement createStatementUnderTest() {
        return new ReindexStatement(null, null, null);
    }
    @Override
    public void hasAtLeastOneGenerator() {
            }
}