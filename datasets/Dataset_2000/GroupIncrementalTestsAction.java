public class GroupIncrementalTestsAction extends AbstractEclipseRefactoringAction {
	private GroupIncrementalTestsRefactoring refactoring;
	@Override
	protected String getRefactoringName() {
				return "Group Incremental Tests";
	}
	@Override
	protected List<String> checkPreConditions() {
				System.out.println("checkPreConditions");
		List<String> lst = new ArrayList<String>();
		return lst;
	}
	@Override
	protected AbstractRefactoring createRefactoringObject() {
				System.out.println("createRefactoringObject");
		refactoring = new GroupIncrementalTestsRefactoring();
		return refactoring;
	}
}