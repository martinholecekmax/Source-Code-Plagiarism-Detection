public class GitCodeHistory implements CodeHistory {
	private static GitCodeHistory instance;
	public static GitCodeHistory getInstance() {
		if (instance == null) {
			instance = new GitCodeHistory();
		}
		return instance;
	}
	private GitCodeHistory() {	
	}
	@Override
	public File checkoutToDate(String project, String url, Date date) {
		throw new NoSuchMethodError("Not implemented");
	}
	@Override
	public File checkoutToDate(String project, File repositoryFolder, final Date date)
			throws CheckoutException, EmptyProjectAtDateException {
		try { 
			File projectFolder = new File(FileUtil.getInstance().createTempDir(), project);
			FileUtil.getInstance().copyDirectory(repositoryFolder, projectFolder);
			GitClient.getInstance().checkout(projectFolder, date);
			return projectFolder;
		} catch (IOException e) {
			throw new CheckoutException(e);
		} catch (RefAlreadyExistsException e) {
			throw new CheckoutException(e);
		} catch (RefNotFoundException e) {
			throw new CheckoutException(e);
		} catch (InvalidRefNameException e) {
			throw new CheckoutException(e);
		} catch (CheckoutConflictException e) {
			throw new CheckoutException(e);
		} catch (GitAPIException e) {
			throw new CheckoutException(e);
		}
	}
	public static void main(String[] args) throws Exception {
		new GitCodeHistory().checkoutToDate("javacv",
				new File("C:\\Users\\fjsj\\Downloads\\EponaProjects\\playframework"),
				new GregorianCalendar(2012, 5, 23).getTime());
	}
}