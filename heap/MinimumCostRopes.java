package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MinimumCostRopes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(minCost(arr, n));

        sc.close();
    }

    static long minCost(long[] arr, int n) {
        long cost = 0l;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long num : arr)
            pq.offer(num);

        while (pq.size() > 1) {
            long num1 = pq.poll();
            long num2 = pq.poll();

            cost += num1 + num2;
            pq.offer(num1 + num2);
        }
        return cost;
    }
}
