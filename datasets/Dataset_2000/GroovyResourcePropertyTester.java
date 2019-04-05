public class GroovyResourcePropertyTester extends PropertyTester {
	
	public static final String hasMain = "hasMain";
	public static final String isScript = "isScript";
	
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		boolean returnValue = false;
		if (hasMain.equals(property) || isScript.equals(property)) {
			if(receiver instanceof IAdaptable) {
				try {
				    ICompilationUnit unit = (ICompilationUnit) ((IAdaptable) receiver).getAdapter(ICompilationUnit.class);
				    if (unit == null) {
	                    IFile file = (IFile) ((IAdaptable) receiver).getAdapter(IFile.class);
				        if (file != null && Util.isJavaLikeFileName(file.getName())) {
				            unit = JavaCore.createCompilationUnitFrom(file);
				        }
				    }
				    if (unit != null) {
				        if (hasMain.equals(property) || isScript.equals(property)) {
    				        List<IType> results = GroovyProjectFacade.findAllRunnableTypes(unit);
    				        returnValue = results.size() > 0;
				        }
				    }
				} catch (IllegalArgumentException e) {
										                } catch (JavaModelException e) {
                                        if (e.getStatus() != null && 
                            e.getStatus().getCode() != IJavaModelStatusConstants.ELEMENT_NOT_ON_CLASSPATH) {
                        GroovyCore.logException("Exception when testing for main methods " + receiver, e);
                    }
                }
			}
		}
		return returnValue;
	}
}