public interface TableEvent {
  
  public static class Cell {
    private int cellIndex;
    private int rowIndex;
    
    public Cell(int rowIndex, int cellIndex) {
      this.cellIndex = cellIndex;
      this.rowIndex = rowIndex;
    }
    
    public int getCellIndex() {
      return cellIndex;
    }
    
    public int getRowIndex() {
      return rowIndex;
    }
  }
  
  public static class Row implements Comparable<Row> {
    private int rowIndex;
    
    public Row(int rowIndex) {
      this.rowIndex = rowIndex;
    }
    public int compareTo(Row o) {
      if (o == null) {
        return 1;
      } else {
        return rowIndex - o.getRowIndex();
      }
    }
    @Override
    public boolean equals(Object o) {
      if (o instanceof Row) {
        return compareTo((Row) o) == 0;
      }
      return false;
    }
    
    public int getRowIndex() {
      return rowIndex;
    }
  }
}