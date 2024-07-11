package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {

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
        bubbleSort(arr);

        // Output the sorted array
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    /**
     * Sorts an array of integers in ascending order using Bubble Sort algorithm.
     *
     * @param arr The array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped in the inner loop, array is already sorted
            if (!swapped) {
                break;
            }
        }
    }
}
