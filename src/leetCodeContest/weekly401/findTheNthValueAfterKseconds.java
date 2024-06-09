package leetCodeContest.weekly401;

import java.util.Arrays;

public class findTheNthValueAfterKseconds {
    private static int MOD = 1000000007;

    public static int valueAfterKSeconds(int n, int k) {
        int[] a = new int[n];
        Arrays.fill(a, 1);

        for (int second = 0; second < k; ++second) {
            int[] newA = new int[n];
            newA[0] = a[0];
            for (int i = 1; i < n; ++i) {
                newA[i] = (newA[i - 1] + a[i]) % MOD;
            }
            a = newA;
        }
        return a[n - 1];
    }
    public static void main(String[] args){
        System.out.println(valueAfterKSeconds(4,5));


        int []arr = {1,2,3,4};
        int []arr1 = {11,12,13,14};
         arr = arr1;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr1));

    }
}
