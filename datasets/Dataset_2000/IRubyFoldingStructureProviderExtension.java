public interface IRubyFoldingStructureProviderExtension {
	
	void collapseMembers();
	
	void collapseComments();
	
	void collapseElements(IRubyElement[] elements);
	
	void expandElements(IRubyElement[] elements);
}