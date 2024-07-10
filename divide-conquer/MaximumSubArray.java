import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter the number of elements: ");
            int n = sc.nextInt();

            if (n <= 0) {
                System.out.println("The number of elements must be positive.");
                return;
            }

            int[] arr = new int[n];
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            List<Integer> result = findMaximumSubArray(arr);
            if (result.isEmpty()) {
                System.out.println("No positive subarray found.");
            } else {
                System.out.println("Maximum subarray:");
                for (int num : result) {
                    System.out.println(num);
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter integers only.");
        } finally {
            sc.close();
        }
    }

    static List<Integer> findMaximumSubArray(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int currentSum = 0, maxSum = Integer.MIN_VALUE;
        int maxStart = -1, maxEnd = -1;
        int currentStart = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                currentSum += arr[i];
                if (currentSum > maxSum || (currentSum == maxSum && (i - currentStart > maxEnd - maxStart))) {
                    maxSum = currentSum;
                    maxStart = currentStart;
                    maxEnd = i;
                }
            } else {
                currentSum = 0;
                currentStart = i + 1;
            }
        }

        if (maxStart == -1 || maxEnd == -1) {
            return res;  // Return an empty list if no positive subarray is found
        }

        for (int i = maxStart; i <= maxEnd; i++) {
            res.add(arr[i]);
        }

        return res;
    }
}
