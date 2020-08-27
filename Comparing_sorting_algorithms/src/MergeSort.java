/**
 * This class implements a merge sort algorithm to sort ineteger arrays
 * reference: ENSF 594 lecture
 * @author David Laditan
 *
 */
public class MergeSort {
	public static void mergeSort(int [] arr, int first, int last) { // Total complexity: O(n) for merge() * O(log n) for recursive mergeSort() = O(nlog n)
		//check to see if there's more than one element in array
		if (first < last) {  // O(1)
			// split array into two halves
			int mid = (first + last)/2;  // O(1)
			
			// continue splitting subarrays recursively
			mergeSort(arr, first, mid); // O(log n): for every mergeSort() call we divide array into two  
			mergeSort(arr, mid +1, last); // O(log n)
			
			merge(arr, first, mid, last); // O(n)
		}
		
		
	}
	
	private static void merge(int [] arr, int left, int mid, int right) { //Complexity: O(1) + O(1) + O(1) + O(1) + O(n) + ... + O(1) = O(n) 
		// step 1: find the sizes of the left and right subarrays
		int leftSize = mid - left + 1;   //O(1)
		int rightSize = right - mid;   // O(1)
		
		//step 2: create a new memory for temp arrays
		int [] leftTemp = new int [leftSize]; // O(1)
		int [] rightTemp = new int [rightSize]; // O(1)
		
		// step 3: copy data to temp arrays
		for (int i = 0; i < leftSize; i++) { // O(n)
			leftTemp[i] = arr[i + left]; // O(1)
		}
		for (int i = 0; i < rightSize; i++) { //O(n)
			rightTemp[i] = arr[mid + 1 + i]; // O(1)
		}
		
		// step 4: merge the temp arrays
		int iLeft = 0; int iRight = 0; // indices for the merged array // O(1)
		int j = left;				//O(1)
		
		while (iLeft < leftSize && iRight < rightSize) { //O(n)
			if (leftTemp[iLeft] <= rightTemp[iRight]) { // O(1)
				arr[j] = leftTemp[iLeft];     //O(1)
				iLeft++;					// O(1)
			}else {
				arr[j] = rightTemp[iRight];   //O(1)
				iRight++;					// O(1)
			}
			j++;			// O(n)
		}
		// Copy the remaining elements of left Temp
		while(iLeft < leftSize) {		// O(n)
			arr[j] = leftTemp[iLeft];	// O(1)
			iLeft++;					// O(1)
			j++;						// O(1)
		}
		// copy the remaining elements of right temp
		while(iRight < rightSize) {		// O(n)
			arr[j] = rightTemp[iRight];	// O(1)
			iRight++;		// O(1)
			j++;			// O(1)
		}

	}

}
