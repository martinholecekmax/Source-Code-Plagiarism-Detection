public class TopicTypeComparator implements Comparator
{
	public int compare(Object o1, Object o2)
	{
		Topic t1 = (Topic)o1;
		Topic t2 = (Topic)o2;
		if (t1.getType() < t2.getType()) {
			return 1;
		}
		else if (t1.getType() == t2.getType()) {
			return t2.getLastPostDate().compareTo(t1.getLastPostDate());
		}
		return -1;
	}
}