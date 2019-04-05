public class WhitespaceHandlingTest extends ChangeGeneratorTest {
	private boolean forReplaced = false;
	public WhitespaceHandlingTest(){
		super("Whitespace Handling in Replace"); 	}
	@Override
	protected void setUp() throws Exception {
		source = "void foo(){\r\n\r\n  for(int i = 0; i < 10; i++){\r\n\r\n  }\r\n\r\n  for(int j = 0; j < 10; j++){\r\n\r\n  }\r\n\r\n}"; 		expectedSource = "void foo(){\r\n\r\n  for(int i = 0; i < 10; i++);\r\n\r\n  for(int j = 0; j < 10; j++){\r\n\r\n  }\r\n\r\n}"; 		forReplaced = false;
		super.setUp();
	}
	public static Test suite() {		
		return new WhitespaceHandlingTest();
	}
	@Override
	protected ASTVisitor createModificator(
			final ASTModificationStore modStore) {
		return new ASTVisitor() {
			{
				shouldVisitStatements = true;
			}
			@Override
			public int visit(IASTStatement statement) {
				if (!forReplaced  && statement instanceof ICPPASTForStatement) {
					ICPPASTForStatement forStatement = (ICPPASTForStatement) statement;
					CPPNodeFactory nf = CPPNodeFactory.getDefault();
					ICPPASTForStatement newFor = forStatement.copy(CopyStyle.withLocations);
					newFor.setBody(nf.newNullStatement());
					ASTModification modification = new ASTModification(ASTModification.ModificationKind.REPLACE, forStatement, newFor, null);
					modStore.storeModification(null, modification);
					forReplaced = true;
				}
				return PROCESS_CONTINUE;
			}
		};
	}
}