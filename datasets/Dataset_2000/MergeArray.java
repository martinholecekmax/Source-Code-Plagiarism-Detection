public class MergeArray {
	public static void merge(int[] A, int[] B) {
		int lenA = A.length;
		int lenB = B.length;
		int iA = 0, iB = 0;
		while (iA < lenA && iB < lenB) {
			if (A[iA] > B[iB]) {
				int tmp = A[iA];
				A[iA] = B[iB];
				B[iB] = tmp;
				iA++;
				Arrays.sort(B);
			} else if (A[iA] == -1) {
				while (iA < lenA && iB < lenB) {
					int tmp = A[iA];
					A[iA] = B[iB];
					B[iB] = tmp;
					iA++;
					iB++;
				}
			} else {
				iA++;
			}
		}
	}
	
	public static void main(String[] args) {
				int[] A = new int[] { 1, 2, 4, 6, -1, -1 };
		int[] B = new int[] { 3, 5 };
		merge(A, B);
		th.util.Printer.arrayPrinter(A);
	}
}