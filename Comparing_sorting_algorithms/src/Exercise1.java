import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
/**
 * 
 * @author David Laditan
 *
 */
public class Exercise1 {
	
	/**
	 * This method generates and returns an array of size 'size' with elements in a 'order' order. Generated array contains duplicate elements.  
	 * 
	 * @param size size of array
	 * @param order order in which array is orientated i.e random , ascending or descending
	 * @return array sample 
	 */
	
	private static int [] generateSample(int size, String order) { // Complexity: O(1) + O(1) + O(n) + O(1) + O(n) + O(1) + O(n) + O(1) = O(n)
		
		int [] array = new int[size]; // O(1)
		
		if (order.equals("random")) { // O(1)
			for (int i = 0; i < array.length; i++) { // O(n)
				array[i] = (int) (Math.random() * size) + 1; // O(1)
			}
		}else if (order.equals("ascending")) { // O(1)
			array[0] = (int)Math.random() * 10; // set first value in array to a number between 0 and 10 // O(1)
			for(int i = 1; i < array.length; i++) // O(n)
				array[i] = array[i-1] + (int)(Math.random()* 5); // each subsequent value should be between 0 to 4 greater than the previous value //O(1)
		}else if (order.equals("descending")) { // O(1)
			array[0] = size * 2; // first value in array to be twice the value of array size // O(1)
			for(int i = 1; i < array.length; i++) // O(n)
				array[i] = array[i-1] - (int) (Math.random() * 5); // each subsequent value should be between 0 to 4 less than the previous value //O(1)
		}
		return array; //O(1)
	}
	
	
	/**
	 *  This method sorts an array with a given algorithm 
	 *  
	 * @param arr sample array 
	 * @param algorithm algorithm to use in sorting array 
	 */
	private static void sortArray(int [] arr, String algorithm) { // Complexity: O(1) + O(n^2) + O(1) + O(nLogn) + O(1) + O(n^2) + O(1) + O(n^2) = O(n^2)
		if (algorithm.equals("insertion"))          // O(1)
			InsertionSort.insertionSort(arr);		// O(n^2)
		else if (algorithm.equals("merge"))			// O(1)
			MergeSort.mergeSort(arr, 0, arr.length - 1); // O(nLogn)
		else if (algorithm.equals("bubble"))			// O(1)
			BubbleSort.bubbleSort(arr);					// O(n^2)
		else if (algorithm.equals("quick"))				// O(1)
			QuickSort.quickSort(arr, 0, arr.length - 1); // O(n^2)
			
	}
	
	/**
	 * This method prints out the time taken to sort a given array.
	 *  
	 * @param arr test array
	 * @param size array size
	 * @param algorithm sorting algorithm
	 * @param order order in which array elements are orientated
	 */
	
	private static void sortTimer(int [] arr,int size,String algorithm, String order) {
		
		long start = System.currentTimeMillis();
		sortArray(arr, algorithm);
		long finish = System.currentTimeMillis();
		
		long executionTime = finish - start;
		
		System.out.println("The execution time of " + algorithm + " sort for " + size + " " + order + " elements is: "  + executionTime + " milliseconds");
	}
	
	
	
	/**
	 * This method runs the experiment to get the time it takes to sort an array of size 'size' with elements 
	 * ordered in 'order' order with a given sorting algorithm. It returns the sorted array as output 
	 * 
	 * @param order
	 * @param size
	 * @param algorithm
	 * @return sorted array 
	 */
	public static int [] runExperiment(String order, int size, String algorithm) { // Total complexity: O(n^2) + O(n) = O(n^2)
		
		int [] testArray = generateSample(size, order); // O(n)
		
		sortTimer(testArray, size, algorithm, order); // O(n^2)
		
		
		return testArray; // O(1)
	}
	
	
	
	/**
	 * This method writes the elements of an array one item per line into a given output file. 
	 * 
	 * @param resultArray array of elements 
	 * @param outputfile file to write array elements into 
	 */
	public static void writeResult(int [] resultArray, String outputFile) {
		try {
			FileWriter myWriter = new FileWriter(outputFile);
			BufferedWriter bw = new BufferedWriter(myWriter);
			
			for (int i = 0; i < resultArray.length; i++) {
				bw.write(resultArray[i] + "\n");
				
			}
			bw.close();
			System.out.println("Successfully wrote sorted array to " + outputFile);
		}catch (IOException e) {
			System.out.println("an error occurred");
			e.printStackTrace();
		}
	}
	
	/**
	 *  test function to run experiments for different combinations of order, algorithm and size
	 */
	
	public static void test() {
		
		String [] order = {"ascending", "random", "descending"};
		int [] size = {10, 100, 1000, 10000, 100000, 1000000};
		String [] algorithm = {"bubble", "insertion", "merge", "quick"};
		int [] testArray;
		
		
		try {
			FileWriter myWriter = new FileWriter("test_result.txt");
			BufferedWriter bw = new BufferedWriter(myWriter);
			
			for (int i = 0; i < order.length; i++) {
				for (int j = 0; j < algorithm.length; j++) {
					for (int k = 0; k < size.length; k++) {
						testArray = generateSample(size[k], order[i]);
						
						long start = System.currentTimeMillis();
						sortArray(testArray, algorithm[i]);
						long finish = System.currentTimeMillis();
						
						long executionTime = finish - start;
						
						bw.write("The execution time of " + algorithm[j] + " sort for " + size[k] + " " + order[i] + " elements is: "  + executionTime + " milliseconds" + "\n");
					}
					
					bw.write("\n");
			}
				bw.write("\n");
		}
			bw.close();
			System.out.println("Successfully wrote to the file.");
		}catch (IOException e) {
			System.out.println("an error occurred");
			e.printStackTrace();
		}
	}
		
		
	
	/**
	 * Method to run the program
	 * @param args command line arguments for order, size, algorithm and output file
	 * @throws Exception
	 */
	public static void main(String [] args) throws Exception {
		
		// Receive command line arguments
	
		String order = args[0];
		String size = args[1];
		String algorithm = args[2];
		String outputFile = args[3];
		
		int arraySize =0;
		
		// Input constraints 
		try {
			arraySize = Integer.parseInt(size);
			if (arraySize < 0)
				throw new Exception("Invalid number");
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		if (!order.equals("random") && !order.equals("ascending") && !order.equals("descending"))
			throw new Exception("Please input random or ascending or descending as order ");
		
		if (!algorithm.equals("bubble") && !algorithm.equals("insertion") && !algorithm.equals("merge") && !algorithm.equals("quick"))
			throw new Exception("Please input one of bubble, insertion or merge or quick as algorithm");
		
		if (!outputFile.endsWith(".txt") && !outputFile.endsWith(".csv"))
			throw new Exception("output file must be .txt");
		

		// run experiment
		int [] result = runExperiment(order, arraySize, algorithm);
		

		// write sorted array to file 
		writeResult(result, outputFile);
			
//		System.out.println(order + " " + size + " " + algorithm + " " + outputFile);
		

		
	}

}
