public class MakePointFree extends RefAction implements IEditorActionDelegate {
  @Override
  void openWizard() {
    RefactoringProcessor processor = new MakePointFreeProcessor( info );
    Ref ref = new Ref( processor );
    MakePointFreeWizard wizard = new MakePointFreeWizard( ref );
    RefactoringWizardOpenOperation op
      = new RefactoringWizardOpenOperation( wizard );
    try {
      String titleForFailedChecks = "";       op.run( getShell(), titleForFailedChecks );
    } catch( final InterruptedException irex ) {
          }
  }
  private class MakePointFreeProcessor extends RefProcessor {
    public MakePointFreeProcessor( final RefInfo info ) {
      super( new MakePointFreeDelegate( info ), UITexts.mkPointFreeProcessor_name );
    }
  }
}