import java.util.*;

public class TwoSum {
	//quick sort method
	public void sort(int arr[], int low, int high) {
		if (low < high) {
			int p = partition(arr, low, high);

			sort(arr, low, p - 1);
			sort(arr, p + 1, high);
		}
	}

	// helper function
	int partition(int arr[], int low, int high) {
		// initializing pivot , set it to highest index in array
		int pivot = arr[high];
		int i = (low - 1);

		// j points to lowest index
		for (int j = low; j < high; j++) {
			// comparing element to pivot to see if there needs to be a switch
			if (arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// switch values
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		//returns i + 1 because it was initially set to 1 lower index
		return i + 1;
	}

	// printing array function
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	// function that removes duplicates in array
	public static int removeDuplicates(int[] array, int n){
		// array contains zero or one element, just return function
		if (n == 0 || n == 1) {
			return n;
		}

		int[] temp = new int[n];
		int j = 0;
		for (int i = 0; i < n - 1; i++) {
			// if current element isn't equal to the next element
			if (array[i] != array[i + 1]) {
				// put that current element into the temp array
				temp[j++] = array[i];
			}
		}
		temp[j++] = array[n - 1];

		// resetting the array
		for (int i = 0; i < j; i++) {
			array[i] = temp[i];
		}
		return j;
	}

	private static int[] findTS(int[] arr, int target, int n) {
		//going thru array
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				// finding if the current value and the one above it add to
				// equal the target
				if (arr[i] + arr[j] == target) {
					// if it does, set the values x and y to each value that it is in
					// and return the new values in the two sum array
					int x = arr[i];
					int y = arr[j];
					return new int[] {x, y};
				}
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		//initializing variables
		int array[] = {1, 7, 4, 7, 2, 9, 13};
		int n = array.length;
		int target = 14;

		System.out.println("Array: ");
		printArray(array); 
		System.out.println("\nTarget: " + target);
		// sort array to find any repeated numbers
		TwoSum qs = new TwoSum();
		qs.sort(array, 0, n - 1);

		// call removeDuplicates function that removes repeated numbers
		n = removeDuplicates(array, n);

		// create new array that will hold 2 values that add to target
		// call function findTS to find the two sums
		int[] twoSums = findTS(array, target, n);


		//if length = 2, that means it successfully found 2 values
		if (twoSums.length == 2) {
			System.out.println(twoSums[0] + " + " + twoSums[1] + " = " + target);
		}
		else {
			System.out.println("No solution.");
		}
	}
}