public final class ComplexArccosh<I extends ComplexType<I>, O extends ComplexType<O>>
	implements ComplexUnaryOperation<I,O>
{
	private final ComplexMultiply<I,I,ComplexDoubleType>
		mulFunc = new ComplexMultiply<I,I,ComplexDoubleType>();
	private final ComplexSubtract<ComplexDoubleType,ComplexDoubleType,ComplexDoubleType>
		diffFunc = new ComplexSubtract<ComplexDoubleType,ComplexDoubleType,ComplexDoubleType>();
	private final ComplexPower<ComplexDoubleType,ComplexDoubleType,ComplexDoubleType>
		powFunc = new ComplexPower<ComplexDoubleType,ComplexDoubleType,ComplexDoubleType>();
	private final ComplexAdd<I,ComplexDoubleType,ComplexDoubleType>
		addFunc = new ComplexAdd<I,ComplexDoubleType,ComplexDoubleType>();
	private final ComplexLog<ComplexDoubleType,O>
		logFunc = new ComplexLog<ComplexDoubleType,O>();
	private static final ComplexDoubleType ONE = new ComplexDoubleType(1,0);
	private static final ComplexDoubleType ONE_HALF = new ComplexDoubleType(0.5,0);
	private final ComplexDoubleType zSquared = new ComplexDoubleType();
	private final ComplexDoubleType miniSum = new ComplexDoubleType();
	private final ComplexDoubleType root = new ComplexDoubleType();
	private final ComplexDoubleType sum = new ComplexDoubleType();
	@Override
	public O compute(I z, O output) {
		mulFunc.compute(z, z, zSquared);
		diffFunc.compute(zSquared, ONE, miniSum);
		powFunc.compute(miniSum, ONE_HALF, root);
		addFunc.compute(z, root, sum);
		logFunc.compute(sum, output);
		return output;
	}
	@Override
	public ComplexArccosh<I,O> copy() {
		return new ComplexArccosh<I,O>();
	}
}