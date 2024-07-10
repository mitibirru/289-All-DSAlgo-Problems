public class MaximumScore {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0, rightSum = 0, sum = 0;

        for (int i = 0; i < k; i++) {
            leftSum += cardPoints[i];
        }

        sum = leftSum;

        int rightIndex = cardPoints.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            leftSum -= cardPoints[i];
            rightSum += cardPoints[rightIndex];

            sum = Math.max(sum, leftSum+rightSum);
            rightIndex--;
        }

        return sum;
    }

    public static void main(String[] args) {
        MaximumScore solution = new MaximumScore();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        int maxScore = solution.maxScore(cardPoints, k);
        System.out.println(maxScore);
    }
}
