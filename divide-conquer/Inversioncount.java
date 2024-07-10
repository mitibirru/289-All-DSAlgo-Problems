import java.util.Scanner;;

public class Inversioncount {
    private static long count;

    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        count = 0; // Reset count before starting
        mergeSort(arr, 0, n - 1);
        return count;
    }

    // Helper function for merge sort.
    private static void mergeSort(long[] arr, int lo, int hi) {
        if (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            mergeSort(arr, lo, mid);
            mergeSort(arr, mid + 1, hi);
            merge(arr, lo, mid, hi);
        }
    }

    // Function to merge two sorted halves and count inversions.
    private static void merge(long[] arr, int lo, int mid, int hi) {
        int n1 = mid - lo + 1;
        int n2 = hi - mid;

        long[] left = new long[n1];
        long[] right = new long[n2];

        System.arraycopy(arr, lo, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        int i = 0, j = 0, k = lo;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += (n1 - i); // Count inversions
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        inversionCount(arr, n);
        System.out.println(count);
        sc.close();
    }
}
