public interface ICompCSModelFactory {
	
	public ICompCS createCompCS();
	
	public ICompCSTaskGroup createCompCSTaskGroup(ICompCSObject parent);
	
	public ICompCSTask createCompCSTask(ICompCSObject parent);
	
	public ICompCSIntro createCompCSIntro(ICompCSObject parent);
	
	public ICompCSOnCompletion createCompCSOnCompletion(ICompCSObject parent);
	
	public ICompCSDependency createCompCSDependency(ICompCSObject parent);
	
	public ICompCSParam createCompCSParam(ICompCSObject parent);
}