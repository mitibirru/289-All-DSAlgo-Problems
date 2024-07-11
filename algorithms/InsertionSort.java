package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the sort method
        insertionSort(arr);

        // Output the sorted array
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    /**
     * Sorts an array of integers in ascending order using Insertion Sort algorithm.
     *
     * @param arr The array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position
            // ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
