public class GameOverCheckerTest {
	@Test
	public void testNewBoardNotGameOver() {
		Board b = new Board();
		assertFalse(GameOverChecker.isGameOver(new BoardState(b)));
	}
	@Test
	public void testGameOverCase1() {
		Board b = new Board();
				b.drop(0, 1);
		b.drop(1, 2);
		b.drop(0, 1);
		b.drop(1, 2);
		b.drop(0, 1);
		b.drop(1, 2);
		b.drop(0, 1);
		assertTrue(GameOverChecker.isGameOver(new BoardState(b)));
	}
	@Test
	public void testGameOverCase2() {
		Board b = new Board();
				b.drop(0, 1);
		b.drop(1, 2);
		b.drop(0, 1);
		b.drop(1, 2);
		b.drop(0, 1);
		b.drop(1, 2);
		
		assertFalse(GameOverChecker.isGameOver(new BoardState(b)));
	}
	@Test
	public void testGameOverCase3() {
		Board b = new Board();
		b.drop(7, Player.ONE);
		b.drop(0, Player.TWO);
		b.drop(7, Player.ONE);
		b.drop(0, Player.TWO);
		b.drop(6, Player.ONE);
		b.drop(1, Player.TWO);
		b.drop(4, Player.ONE);
		b.drop(1, Player.TWO);
		b.drop(4, Player.ONE);
		b.drop(2, Player.TWO);
		b.drop(4, Player.ONE);
		b.drop(3, Player.TWO);
		assertTrue(GameOverChecker.isGameOver(b.state()));
	}
}