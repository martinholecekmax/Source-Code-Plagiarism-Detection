public interface Randable {
   public static final int START_STREAM    = 1;
   public static final int START_SUBSTREAM = 2;
   public static final int NEXT_SUBSTREAM  = 3;
   public double randU01 ();
   public int    randInt (int i, int j);
   public void   setAntithetic (boolean a);
   public void   resetStream (int where);
}