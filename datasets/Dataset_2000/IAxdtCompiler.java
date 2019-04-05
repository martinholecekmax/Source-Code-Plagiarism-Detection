public interface IAxdtCompiler extends IAxdtExtension {
	String EXTENSION_ID = "org.axdt.core.compiler.axdtCompiler";
	boolean compile(AxdtLaunchContext context, IProgressMonitor monitor) throws Exception;
}