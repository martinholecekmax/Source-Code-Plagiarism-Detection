public interface GridChild extends Child
{
    
    GridAlignment getHorizontalAlignment();
    
    void setHorizontalAlignment(GridAlignment value);
    
    GridAlignment getVerticalAlignment();
    
    void setVerticalAlignment(GridAlignment value);
    
    boolean isGrabHorizontalSpace();
    
    void setGrabHorizontalSpace(boolean value);
    
    boolean isGrabVerticalSpace();
    
    void setGrabVerticalSpace(boolean value);
    
    int getSpanCols();
    
    void setSpanCols(int value);
    
    int getSpanRows();
    
    void setSpanRows(int value);
}