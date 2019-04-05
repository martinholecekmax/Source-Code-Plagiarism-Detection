public class PajekWriter {
    public PajekWriter() { }
    
    public <T> void write(WeightedDirectedMultigraph<T> g, File f) 
            throws IOException {
        write(g, f, null);
    }
    
    public <T> void write(WeightedDirectedMultigraph<T> g, File f, 
                          Indexer<String> vertexLabels) 
            throws IOException {
        PrintWriter pw = new PrintWriter(f);
        pw.println("*Vertices " + g.order());
        if (vertexLabels != null) {
            IntIterator iter = g.vertices().iterator();
            while (iter.hasNext()) {
                int v = iter.nextInt();
                String label = vertexLabels.lookup(v);
                if (label != null)
                    pw.printf("%d \"%s\"%n", v, label);
            }
        }
                                pw.println("*Edges");
        IntIterator iter = g.vertices().iterator();
        while (iter.hasNext()) {
            int v1 = iter.nextInt();
            IntIterator iter2 = g.getNeighbors(v1).iterator();
            while (iter2.hasNext()) {
                int v2 = iter2.nextInt();
                if (v1 < v2)
                    continue;
                Set<? extends WeightedEdge> edges = g.getEdges(v1, v2);
                double fromWeight = 0;
                double toWeight = 0;
                for (WeightedEdge e : edges) {
                    if (e.from() == v1)
                        fromWeight += e.weight();
                    else
                        toWeight += e.weight();
                }
                if (fromWeight != 0)
                    pw.printf("%d %d %f%n", v1, v2, fromWeight);
                if (toWeight != 0)
                    pw.printf("%d %d %f%n", v2, v1, toWeight);
            }
        }
        pw.close();
    }   
}