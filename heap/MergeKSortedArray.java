package heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeKSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("The number of arrays should be greater than 0.");
            sc.close();
            return;
        }

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        mergeKArrays(arr, n);

        sc.close();
    }

    static ArrayList<Integer> mergeKArrays(int[][] arr, int n) {
        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < n; i++)
            pq.offer(new Pair(arr[i][0], 0, i));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            res.add(p.value);

            if (p.value_index + 1 < n)
                pq.offer(new Pair(arr[p.arr_index][p.value_index + 1], p.value_index + 1, p.arr_index));
        }

        return res;
    }
}

class Pair {
    int value;
    int value_index;
    int arr_index;

    public Pair(int v, int vi, int ai) {
        this.value = v;
        this.arr_index = ai;
        this.value_index = vi;
    }
}