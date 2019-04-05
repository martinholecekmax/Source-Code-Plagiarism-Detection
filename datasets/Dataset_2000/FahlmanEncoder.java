public class FahlmanEncoder {
	public static final int INPUT_OUTPUT_COUNT = 10;
	public static final int HIDDEN_COUNT = 5;
	public static final int TRIES = 2500;
	public static final boolean COMPL = false;
	public static MLDataSet generateTraining(int inputCount, boolean compl) {
		double[][] input = new double[INPUT_OUTPUT_COUNT][INPUT_OUTPUT_COUNT];
		double[][] ideal = new double[INPUT_OUTPUT_COUNT][INPUT_OUTPUT_COUNT];
		for (int i = 0; i < inputCount; i++) {
			for (int j = 0; j < inputCount; j++) {
				if (compl) {
					input[i][j] = (j == i) ? 0.0 : 1.0;
				} else {
					input[i][j] = (j == i) ? 1.0 : 0.0;
				}
				ideal[i][j] = input[i][j];
			}
		}
		return new BasicMLDataSet(input, ideal);
	}
	public static void main(String[] args) {		
		MLDataSet trainingData = generateTraining(INPUT_OUTPUT_COUNT, COMPL);
		MLMethod method = EncogUtility.simpleFeedForward(INPUT_OUTPUT_COUNT,
				HIDDEN_COUNT, 0, INPUT_OUTPUT_COUNT, false);
		LevenbergMarquardtTraining train = new LevenbergMarquardtTraining((BasicNetwork) method, trainingData);
		EncogUtility.trainToError(train, 0.01);
		Encog.getInstance().shutdown();
	}
}