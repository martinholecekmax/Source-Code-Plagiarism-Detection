public class ForagerTest extends TestCase {
    public void testPicking() {
        Forager forager = new MaxScoreOfAllForager();
        forager.setLocalSearchSolver(new DefaultLocalSearchSolver() {
            public Random getRandom() {
                return new Random();
            }
        });
        forager.solvingStarted();
        forager.beforeDeciding();
        Move a = new DummyMove();
        Move b = new DummyMove();
        Move c = new DummyMove();
        Move d = new DummyMove();
        Move e = new DummyMove();
        forager.addMove(a, -100.0, 10000.0);
        forager.addMove(b, -90.0, 2000.0);
        forager.addMove(c, -100.0, 300.0);
        forager.addMove(d, -190.0, 40.0);
        forager.addMove(e, -90.0, 5.0);
        Move picked = forager.pickMove();
        assertTrue(picked == b || picked == e);
        List<Move> topList = forager.getTopList(3);
        assertTrue(topList.contains(a));
        assertTrue(topList.contains(b));
        assertFalse(topList.contains(c));
        assertFalse(topList.contains(d));
        assertTrue(topList.contains(e));
        forager.solvingEnded();
    }
    public static class DummyMove implements Move {
        public boolean isMoveDoable(WorkingMemory workingMemory) {
            return false;          }
        public Move createUndoMove(WorkingMemory workingMemory) {
            return null;          }
        public void doMove(WorkingMemory workingMemory) {
                    }
    }
}