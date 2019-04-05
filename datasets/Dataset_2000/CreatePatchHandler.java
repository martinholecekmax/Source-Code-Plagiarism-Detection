public class CreatePatchHandler extends AbstractHistoryCommandHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<RevCommit> selectedCommits = getSelectedCommits();
		RevCommit commit = selectedCommits.get(0);
		Repository repo = getRepository(event);
		PatchOperationUI.createPatch(getPart(event), commit, repo).start();
		return null;
	}
	@Override
	public boolean isEnabled() {
		GitHistoryPage page = getPage();
		if (page == null)
			return false;
		IStructuredSelection selection = getSelection(page);
		if (selection.size() != 1)
			return false;
		RevCommit commit = (RevCommit) selection.getFirstElement();
		return (commit.getParentCount() == 1);
	}
}