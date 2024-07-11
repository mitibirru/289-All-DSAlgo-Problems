package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Input the array elements (assuming elements are within a specific range)
        System.out.print("Enter the maximum element in the array: ");
        int maxElement = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the sort method
        countingSort(arr, maxElement);

        // Output the sorted array
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    /**
     * Sorts an array of integers in ascending order using Counting Sort algorithm.
     *
     * @param arr        The array to be sorted
     * @param maxElement The maximum element in the array
     */
    public static void countingSort(int[] arr, int maxElement) {
        int n = arr.length;

        // Create a count array to store count of occurrences of each element
        int[] count = new int[maxElement + 1];

        // Store count of each element
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Modify count array to store actual position of elements
        for (int i = 1; i <= maxElement; i++) {
            count[i] += count[i - 1];
        }

        // Output array that will have sorted elements
        int[] output = new int[n];

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy the sorted elements back into original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}
