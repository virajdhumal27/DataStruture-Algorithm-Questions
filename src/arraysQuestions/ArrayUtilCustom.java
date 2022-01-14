package arraysQuestions;

public class ArrayUtilCustom {
	/*
	 * Prints array.
	 */
	public static void printArray(int[] arr) {
		int n = arr.length;
		printArray(arr, 0, n);
	}
	
	/*
	 * Prints array from 0 to n(n excluded).
	 * @param - array
	 * @param - length
	 */
	public static void printArray(int[] arr, int end) {
		printArray(arr, 0, end);
	}
	
	/*
	 * Prints array from start(inclusive) to end(exclusive).
	 * 
	 * @param - array
	 * @param - start
	 * @param - end
	 */
	public static void printArray(int[] arr, int start, int end) {
		System.out.print("[ ");
		for (int i = start; i < end - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[end - 1] + " ]");
	}
}
