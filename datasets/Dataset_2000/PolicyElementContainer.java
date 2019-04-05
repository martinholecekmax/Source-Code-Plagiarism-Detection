public interface PolicyElementContainer extends NodeContainer
{
	void add(PolicyElementNode node);
	void add(int index, PolicyElementNode node);
	void add(PolicyTreeElement element);
	void add(int index, PolicyTreeElement element);
	void remove(PolicyElementNode node);
	boolean containsId(String id);
}