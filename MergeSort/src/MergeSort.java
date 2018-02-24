import java.util.Scanner;

//http://www.geeksforgeeks.org/merge-sort/

class MergeSort {
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r) {


		System.out.println("Finding size of the 2 sub arrays to be merged");
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		System.out.println("Creating temporary arrays");
		/* Creates temporary arrays to store the newly merged & sorted arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data from the newly sorted & merged arrays  into temp arrays */
		System.out.println("Storing newly sorted & merged arrays into temporary arrays L & R");
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		//System.out.println("Copy remaining elements of L[] if any");
		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		//System.out.println("Copy remaining elements of L[] if any");
		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r) {
		if (l < r) {

			// Find the middle point
			System.out.println("Discerning midpoint of array");		
			int m = (l + r) / 2;

			System.out.println("Sorting the 1st and 2nd halves");
			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			System.out.println("Merge the sorted halves");
			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[]) {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter the number of elements: ");
		int[] arr = new int[input.nextInt()];
		// Create a new array. The user enters the size

		System.out.println("Enter elements");
		for(int i = 0; i < arr.length; i++)
			arr[i] = input.nextInt();
		// User assigns the values for each element in the array


		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
