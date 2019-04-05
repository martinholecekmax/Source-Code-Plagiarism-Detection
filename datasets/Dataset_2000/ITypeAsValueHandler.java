public interface ITypeAsValueHandler<T> extends IApplicable {
	
	T getValue(BuildProcess process, Node node, String key, Object inputValue) throws BuildException;
	
	String getRegex();
	
	String getInputValueSample();
}