import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

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

        // Create an instance of Solution (assuming Solution is the class name)
        MergeSort solution = new MergeSort();

        // Call mergeSort to sort the array
        solution.mergeSort(arr, 0, n - 1);

        // Output the sorted array
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }

    /**
     * Merge two subarrays of arr[]. First subarray is arr[l..m], second subarray is
     * arr[m+1..r]
     * 
     * @param arr The array to be sorted
     * @param l   Left index of the subarray
     * @param m   Middle index of the subarray
     * @param r   Right index of the subarray
     */
    void merge(int arr[], int l, int m, int r) {
        ArrayList<Integer> temp = new ArrayList<>();

        int left = l, right = m + 1;

        while (left <= m && right <= r) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= m) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= r) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = l; i <= r; i++) {
            arr[i] = temp.get(i - l);
        }
    }

    /**
     * Main function that sorts arr[l..r] using merge()
     * 
     * @param arr The array to be sorted
     * @param l   Left index of the subarray
     * @param r   Right index of the subarray
     */
    void mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;

            // Sort first and second halves
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            // Merge the sorted halves
            merge(arr, l, mid, r);
        }
    }
}
