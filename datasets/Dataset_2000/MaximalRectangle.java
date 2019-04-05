public class MaximalRectangle {
  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    int m = matrix.length, n = matrix[0].length;
    int[] height = new int[n];
    int max = 0;
    System.out.println("Height == ");
    LargestRectangle largestRectangle = new LargestRectangle();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        height[j] = matrix[i][j] == '1' ? height[j] + 1 : 0;
        System.out.print(height[j]);
      }
      System.out.println();
      if (i == 6) {
        System.out.println("AAA");
      }
      int curMax = largestRectangle.largestRectangleArea(height);
      if (curMax > max) {
        max = curMax;
      }
    }
    return max;
  }
  public int maximalRectangle(String[] matrix) {
    if (matrix.length == 0) {
      return 0;
    }
    char[][] m = new char[matrix.length][matrix[0].length()];
    System.out.println("Matrix == ");
    for (int i = 0; i < matrix.length; i++) {
      m[i] = matrix[i].toCharArray();
      System.out.println(matrix[i]);
    }
    return maximalRectangle(m);
  }
  public static void main(String[] args) {
    MaximalRectangle m = new MaximalRectangle();
    String[] matrix = new String[]{
        "10011011", "10000100", "01110011", "00010001", "00000111", "11111111", "10010110", "01101110"
    };
    System.out.println(m.maximalRectangle(new String[]{"0010", "1111", "1111", "1110", "1100", "1111", "1110"}));
  }
}