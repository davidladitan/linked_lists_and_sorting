import java.util.Arrays;

/**
 * This class implements an insertion sort algorithm to sort integer arrays
 * reference: ENSF 594 lecture
 * @author David Laditan
 *
 */
public class InsertionSort {
	public static void insertionSort(int [] arr) {  // Total complexity: O(n) * O(n) + O(1) + O(1) + O(1) = O(n^2)
		for (int i = 1; i < arr.length; i++) { // O(n)
			for(int j = i; j > 0 && arr[j - 1] > arr[j]; j--) { // O(n)
				int temp = arr[j]; // O(1)
				arr[j] = arr[j-1];	// O(1)
				arr[j-1] = temp; // O(1)
			}
		}
	}
	
	public static void main(String [] args) {
		int [] array = {7,5,8,3,1,9};
		
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

}
