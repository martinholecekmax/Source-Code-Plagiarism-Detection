public class Test002ExtendingRandomizedTest extends RandomizedTest {
  @Test
  public void getContextByHand() {
    RandomizedContext context = RandomizedContext.current();
    Random rnd = context.getRandom();
    System.out.println("Random, next int: " + rnd.nextInt());
  }
  @Test
  public void getContextFromSuper() {
    Random rnd = super.getRandom();
    System.out.println("Random, next int: " + rnd.nextInt());
  }
}