package HardProblems;

import java.util.Arrays;

public class CountSubStringThatSatisfyKConstraints_II {
    public static long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int i=0; int zero=0; int one=0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(j) == '0') zero++;
            else one++;

            while (one > k && zero > k) {
                if (s.charAt(i) == '0') zero--;
                else one--;
                i++;
            }
            left[j] = i;
        }

        int b=n-1; int on=0; int zr=0;
        for (int a=n-1; a>= 0; a--) {
            if (s.charAt(a) == '0') zr++;
            else on++;

            while (on > k && zr > k) {
                if (s.charAt(b) == '0') zr--;
                else on--;
                b--;
            }
            right[a] = b;
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = 1;

        for (int x = 1; x < n; x++) {
            prefixSum[x] = prefixSum[x - 1] + (x - left[x] + 1);
        }

        long[] ans = new long[m];

        for (int ii = 0; ii < m; ii++) {
            int start = queries[ii][0];
            int end = queries[ii][1];
            int mid = Math.min(end, right[start]);

            long length = mid - start + 1;
            long substr = length * (length + 1) / 2;
            long temp = prefixSum[end] - prefixSum[mid];
            ans[ii] = substr + temp;
        }
        return ans;
    }


    public static void main(String[] args) {
        String s ="010101";
        int k = 1;
        int[][]queries = {
                {0,5},
                {1,4},
                {2,3}
        };

        System.out.println(Arrays.toString(countKConstraintSubstrings(s,k,queries)));
    }
}
