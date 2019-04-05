public interface ForwardIterator extends InputIterator, OutputIterator
  {
  
  public void advance();
  
  public void advance( int n );
  
  public Object get( int offset );
  
  public void put( int offset, Object object );
  
  public int distance( ForwardIterator iterator );
  
  public Object clone();
  
  public Container getContainer();
  }