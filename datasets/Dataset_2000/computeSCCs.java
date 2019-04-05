public class computeSCCs {
	
	public static void main(String[] args) throws IOException {
		System.out.println("This program will compute the SCCs in a Directed Graph.");
		body();
		System.out.println("End of Program.");
	}
	public static void body() throws IOException{
				int[][][] bigGraph = DirectedGraph.generateArrays("P4", "test1", 9);
		int[][] G = bigGraph[0];
		int[][] Grev = bigGraph[1];
		DirectedGraph.print(G);
		System.out.println("--------");
		DirectedGraph.print(Grev);
		System.out.println("--------");
			}
}