import java.util.Arrays;

/**
 * This class implements a quick sort algorithm to sort ineteger arrays.
 * @author David Laditan
 *
 */
public class QuickSort {
	
	private static void swap(int arr[], int i, int j) { // complexity: O(1)
        int t = arr[i]; 					// O(1)
        arr[i] = arr[j]; 					// O(1)
        arr[j] = t;  						// O(1)
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    private static int partition(int arr[], int l, int h) { // complexity: O(n)
        int x = arr[h]; 						// O(1)
        int i = (l - 1); 						// O(1)
  
        for (int j = l; j <= h - 1; j++) { 		// O(n) 
            if (arr[j] <= x) {  				// O(1)
                i++;     						// O(1)
                // swap arr[i] and arr[j] 
                swap(arr, i, j);   				// O(1)
            } 
        } 
        // swap arr[i+1] and arr[h] 
        swap(arr, i + 1, h);       				// O(1)
        return (i + 1); 						// O(1)
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    public static void quickSort(int arr[], int l, int h) { // Total complexity: O(n^2) + O(1) + O(1) + O(1) + O(1) = O(n^2) 
        // create auxiliary stack 
        int stack[] = new int[h - l + 1]; 			// O(1)
  
        // initialize top of stack 
        int top = -1; 								// O(1)
  
        // push initial values in the stack 
        stack[++top] = l; 							// O(1)
        stack[++top] = h; 							// O(1)
  
        // keep popping elements until stack is not empty 
        while (top >= 0) {  						// while loop complexity: O(n) * O(n) + O(1) +.....+ O(1)  = O(n^2)  
            // pop h and l 
            h = stack[top--]; 						// O(1)
            l = stack[top--]; 						// O(1)
  
            // set pivot element at it's proper position 
            int p = partition(arr, l, h); 			// O(n)
  
            // If there are elements on left side of pivot, 
            // then push left side to stack 
            if (p - 1 > l) { 						// O(1)
                stack[++top] = l; 					// O(1)
                stack[++top] = p - 1; 				// O(1)
            } 
  
            // If there are elements on right side of pivot, 
            // then push right side to stack 
            if (p + 1 < h) { 						// O(1)
                stack[++top] = p + 1; 				// O(1)
                stack[++top] = h; 					// O(1)
            } 
        } 
    }
    
    public static void main(String args[]) 
    { 
        
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        quickSort(arr, 0, arr.length - 1);
        
        System.out.println(Arrays.toString(arr));
         
    } 


}
