public class Cogito
{
  static final boolean BOOSTRAP = false;
  static final boolean THINK = false;
  
  public static void main(String[] args)
  {
        AC agent = new AC();
    if (BOOSTRAP)
      {
        agent.bootstrap();
        System.exit(0);
      }
    if (THINK)
      {
        agent.think();
        System.exit(0);
      }
        agent.run();
    System.out.println("Stopped");
  }
}