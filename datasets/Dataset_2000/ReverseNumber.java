public class ReverseNumber {
  public int reverse(int x) {
    boolean isNeg = false;
    if (x < 0) {
      x = -x;
      isNeg = true;
    }
    int r = 0;
    while (x > 0) {
      r = r * 10 + x % 10;
      x = x / 10;
    }
    return isNeg ? -r : r;
  }
}