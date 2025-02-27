package DP;

public class LengthofLongestFibonacciSubsequence {

    public static int fun(int one, int two, int[] arr, int[][] dp) {
        // Base case
        if (one < 0 || two < 0) return 0;

        // If already computed, return the value
        if (dp[one][two] != -1) return dp[one][two];

        int maxLen = 0;

        // Try to find the previous element that forms the Fibonacci-like sequence
        for (int prev = one - 1; prev >= 0; prev--) {
            if (arr[prev] + arr[one] == arr[two]) {
                maxLen = fun(prev, one, arr, dp) + 1;
                break; // No need to continue once the sequence is found
            }
        }

        return dp[one][two] = maxLen;
    }

    public static int lenLongestFibSubseq(int[] arr) {
        int maxLen = 0;
        int n = arr.length;
        int[][] dp = new int[n][n];

        // Initialize dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        // Start the sequence with every possible pair
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = fun(i, j, arr, dp);
                maxLen = Math.max(maxLen, len);
            }
        }

        return (maxLen == 0) ? 0 : maxLen + 2; // Add 2 to include the first two elements
    }







    
    public static void main(String[] args) {

    }
}
