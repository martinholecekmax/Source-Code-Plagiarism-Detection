public class TestInsertPerf extends TestCaseWithTestFile {
    int _numberOfObjects = 1000;
    public void testInsert() throws IOException {
        long start, finish;
        DBAbstract db = newDBCache();
        BTree btree = BTree.createInstance(db);
                                start = System.currentTimeMillis();
        for (int i = 0; i < _numberOfObjects; i++) {
            btree.insert(new Long(i), new Integer(i), false);
        }
        db.commit();
        finish = System.currentTimeMillis();
        System.out.println("It took " + (finish - start) + " ms to insert "
                + _numberOfObjects + " objects.");
    }
}