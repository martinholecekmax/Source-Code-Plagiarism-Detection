public abstract class GitBase extends DefaultTask {
	private Object repoPath = getProject().getRootProject().getProjectDir();
	
	protected File getRepoDir() {
		return getProject().file(repoPath);
	}
	
	public void setRepoPath(Object repoPath) {
		this.repoPath = repoPath;
	}
	
	protected Git getGit() {
		try {
			return Git.open(getRepoDir());
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}
}