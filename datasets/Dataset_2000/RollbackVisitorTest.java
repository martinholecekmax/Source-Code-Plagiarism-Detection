public class RollbackVisitorTest {
    @Test
    public void visit() throws Exception {
        Database database = createMock(Database.class);
        ChangeSet changeSet = createMock(ChangeSet.class);
        changeSet.rollback(database);
        expectLastCall();
        database.removeRanStatus(changeSet);
        expectLastCall();
        database.commit();
        expectLastCall();
        replay(changeSet);
        replay(database);
        RollbackVisitor visitor = new RollbackVisitor(database);
        visitor.visit(changeSet, new DatabaseChangeLog(), database);
        verify(database);
        verify(changeSet);
    }
}