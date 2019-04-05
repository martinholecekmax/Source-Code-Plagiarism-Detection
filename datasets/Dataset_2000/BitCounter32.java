public final class BitCounter32 implements BitmapStorage32 {
    
    public void add(final int newdata) {
    this.oneBits += Integer.bitCount(newdata);
  }
  
    public void addStreamOfDirtyWords(int[] data, int start, int number) {
    for(int i=start;i<start+number;i++) {
      add(data[i]);      
    }
  }
  
    public void addStreamOfEmptyWords(boolean v, int number) {
    if (v) {
      this.oneBits += number * EWAHCompressedBitmap32.wordinbits;
    }
  }
  
    public void addStreamOfNegatedDirtyWords(int[] data, int start,
    int number) {
    for(int i=start;i<start+number;i++) {
      add(~data[i]);      
    }
  }
  
  public int getCount() {
    return this.oneBits;
  }  
  
    public void setSizeInBits(int bits) {
      }
  private int oneBits;
}