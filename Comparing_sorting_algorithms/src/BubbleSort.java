import java.util.Arrays;

/**
 * This class implements a bubble sort algorithm to sort integer arrays
 * reference: ENSF 594 lecture
 * @author David Laditan
 *
 */
public class BubbleSort {
	public static void bubbleSort(int [] arr) { // Total complexity: O(n) * O(n) + O(1) + O(1) + O(1) + O(1) = O(n^2)
		for (int i = 0; i < arr.length - 1; i++) { // O(n)
			for (int j = arr.length -1; j >= 1; j--) { // O(n)
				if (arr[j] < arr[j -1]) { // O(1)
					int temp = arr[j-1]; // O(1)
					arr[j-1] = arr[j]; // O(1)
					arr[j] = temp;  // O(1)
				}
			}
		}
	}
	
//	public static void main(String [] args) {
//		int [] array = {7, 5, 8, 3, 1, 9};
//		bubbleSort(array);
//		
//		System.out.println(Arrays.toString(array));
//		
////		for (int i = 0; i < array.length; i++)
////			System.out.println(array[i] + " ");
//	}
}
