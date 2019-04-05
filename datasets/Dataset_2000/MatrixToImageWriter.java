public final class MatrixToImageWriter {
  private static final int BLACK = 0xFF000000;
  private static final int WHITE = 0xFFFFFFFF;
  private MatrixToImageWriter() {}
  
  public static BufferedImage toBufferedImage(BitMatrix matrix) {
    int width = matrix.getWidth();
    int height = matrix.getHeight();
    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
      }
    }
    return image;
  }
  
  public static void writeToFile(BitMatrix matrix, String format, File file)
          throws IOException {
    BufferedImage image = toBufferedImage(matrix);
    ImageIO.write(image, format, file);
  }
  
  public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
          throws IOException {
    BufferedImage image = toBufferedImage(matrix);
    ImageIO.write(image, format, stream);
  }
}