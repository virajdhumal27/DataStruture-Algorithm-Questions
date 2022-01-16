package arraysQuestions;

/**
 * ArrayUtilCustom is a helper class for printing various arrays and reduce unnecessary complexity.
 * This class will not be used for solving problems.
 * 
 * This class will be updated, if required to support more array related operations.
 */
public class ArrayUtilCustom {
	
	/**
	 * Prints array.
	 * 
	 * @param - array
	 */
	public static void printArray(int[] arr) {
		int n = arr.length;
		printArray(arr, 0, n);
	}
	
	/**
	 * Prints array from 0 to n (n excluded).
	 * @param - array
	 * @param - length
	 */
	public static void printArray(int[] arr, int end) {
		printArray(arr, 0, end);
	}
	
	/**
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
	
	/**
	 * Prints 2-dimensional array.
	 * 
	 * @param - Array
	 */
	public static void print2dArray(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		
		System.out.print("{ ");
		for (int i = 0; i < n - 1; i++) {
			int[] row = arr[i];
			System.out.print("[ ");
			
			for(int j = 0; j < m - 1; j++) {
				System.out.print(row[j] + ", ");
			}
			
			System.out.print(row[m - 1] + " ], ");
		}
		
		System.out.print("[ ");
		for (int i = 0; i < m - 1; i++) {
			System.out.print(arr[n-1][i] + ", ");
		}
		
		System.out.println(arr[n-1][m-1] + " ] }");
	}
	
	/**
	 * Prints a 2-dimensional array in a table format.
	 * 
	 * @param - Array
	 * @
	 */
	public static void printArrayTable(int[][] arr) {
		for(int[] row: arr) {
			printArray(row);
		}
	}
}
