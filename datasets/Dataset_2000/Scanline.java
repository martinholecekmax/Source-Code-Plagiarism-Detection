class Scanline
{
  
  private PolyEdge edges;
  
  void clear()
  {
    edges = null;
  }
  
  Scanline()
  {
      }
  
  void addEdge(PolyEdge edge)
  {
        edge.scanlineNext = edges;
    edges = edge;
  }
  
  PolyEdge getEdges()
  {
    return edges;
  }
}