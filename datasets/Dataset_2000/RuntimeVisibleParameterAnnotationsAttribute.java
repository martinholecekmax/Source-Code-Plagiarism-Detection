public class RuntimeVisibleParameterAnnotationsAttribute extends ClassFileAttribute {
	private static final ParameterAnnotation[] NO_ENTRIES = new ParameterAnnotation[0];
	private int parametersNumber;
	private ParameterAnnotation[] parameterAnnotations;
	
	public RuntimeVisibleParameterAnnotationsAttribute(byte[] classFileBytes, ConstantPool constantPool, int offset) throws ClassFormatException {
		super(classFileBytes, constantPool, offset);
		final int length = u1At(classFileBytes, 6, offset);
		this.parametersNumber = length;
		if (length != 0) {
			int readOffset = 7;
			this.parameterAnnotations = new ParameterAnnotation[length];
			for (int i = 0; i < length; i++) {
				ParameterAnnotation parameterAnnotation = new ParameterAnnotation(classFileBytes, constantPool, offset + readOffset);
				this.parameterAnnotations[i] = parameterAnnotation;
				readOffset += parameterAnnotation.sizeInBytes();
			}
		} else {
			this.parameterAnnotations = NO_ENTRIES;
		}
	}
	
	public ParameterAnnotation[] getParameterAnnotations() {
		return this.parameterAnnotations;
	}
	
	public int getParametersNumber() {
		return this.parametersNumber;
	}
}