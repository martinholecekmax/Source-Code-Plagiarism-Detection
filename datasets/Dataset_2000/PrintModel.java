public class PrintModel {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		if(args.length != 1) {
			System.out.println("Usage: PrintModel <model-file>");
			System.exit(-1);
		}
		String modelFile = args[0];
		Model model = Model.readFromFile(modelFile);
		System.out.println(model);
	}
}