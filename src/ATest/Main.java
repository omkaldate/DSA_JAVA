package ATest;

public class Main {

    public static int maximizeRatings(int[] ratings) {
        int n = ratings.length;
        if (n == 0) return 0;
        if (n == 1) return ratings[0];

        int[] dp = new int[n];

        dp[0] = Math.max(0, ratings[0]);
        dp[1] = Math.max(dp[0] + ratings[1], ratings[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + ratings[i]);
            
            if(i - 3 >= 0)
            dp[i] = Math.max(dp[i], dp[i - 3] + ratings[i - 1] + ratings[i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] ratings = {9, -1, -3, 4, 5};
        System.out.println(maximizeRatings(ratings));
    }
}