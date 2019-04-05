public class GetOccurrenceOfNumberInSortedArray {
	public int getOccurrence(int k, int[] numbers, int start, int end) {
		if(end < start) return 0;
		if(numbers[start] > k) return 0;
		if(numbers[end] < k) return 0;
		if(numbers[start] == k && numbers[end] == k) return end-start+1;
		int mid = (start+end)/2;
		if(numbers[mid] == k) 
			return 1 + getOccurrence(k, numbers, start, mid-1) + getOccurrence(k, numbers, mid+1, end);
		else if(numbers[mid] > k) 
			return getOccurrence(k, numbers, start, mid-1);
		else 
			return getOccurrence(k, numbers, mid+1, end);
	}
}