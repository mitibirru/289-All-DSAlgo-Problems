package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElementStream {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("The size of array should be greater than 0.");
            sc.close();
            return;
        }

        int k = sc.nextInt();
        if (k < 1 || k > n) {
            System.out.println("The value of k should be in range of 1 and " + n + '.');
            sc.close();
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(kthLargest(arr, n, k));

        sc.close();
    }

    static int[] kthLargest(int[] arr, int n, int k) {
        int[] res = new int[n];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (pq.size() < k) {
                pq.offer(arr[i]);
            } else {
                if (arr[i] > pq.peek()) {
                    pq.poll();
                    pq.offer(arr[i]);
                }
            }

            if (pq.size() >= k) {
                res[i] = pq.peek();
            } else {
                res[i] = -1;
            }
        }

        return res;
    }
}
