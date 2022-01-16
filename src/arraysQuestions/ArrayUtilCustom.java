package arraysQuestions;

/**
 * ArrayUtilCustom is a helper class for printing various arrays and reduce unnecessary complexity.
 * This class will not be used for solving problems.
 * 
 * This class will be updated, if required to support more array related operations.
 * 
 * @since 2022-01-16
 */
public class ArrayUtilCustom {
	
	/**
	 * Prints array.
	 * 
	 * @param arr Array to traverse and print.
	 */
	public static void printArray(int[] arr) {
		int n = arr.length;
		printArray(arr, 0, n);
	}
	
	/**
	 * Prints array from 0 to n (n excluded).
	 * 
	 * @param arr Array to traverse and print.
	 * @param end End index of array.
	 */
	public static void printArray(int[] arr, int end) {
		printArray(arr, 0, end);
	}
	
	/**
	 * Prints array from start(inclusive) to end(exclusive).
	 * 
	 * @param arr Array to traverse and print.
	 * @param start Start index of array.
	 * @param end End index of array.
	 */
	public static void printArray(int[] arr, int begin, int end) {
		System.out.print("[ ");
		for (int i = begin; i < end - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[end - 1] + " ]");
	}
	
	/**
	 * Prints 2-dimensional array.
	 * 
	 * @param arr A 2D Array to traverse and print.
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
	 * @param arr A 2d array to be printed in table format.
	 */
	public static void printArrayTable(int[][] arr) {
		for(int[] row: arr) {
			printArray(row);
		}
	}
}
