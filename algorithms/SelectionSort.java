package algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
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
        sort(arr, n);

        // Output the sorted array
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    static void sort(int[] arr, int n) {
        for (int i = 0; i <= n - 2; i++) {
            int min_index = i;
            for (int j = i; j <= n - 1; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }

            if (min_index != i) {
                int temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
    }
}
