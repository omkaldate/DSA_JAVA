package Maths;

import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPrimeNumbersnRange {
    public static int[] closestPrimes(int left, int right) {
        // int limit = (int) 1e7;
        int[] pr = new int[right + 1];
        Arrays.fill(pr, 1);

        pr[0] = pr[1] = 0;

        for (int i = 2; i * i <= right; i++) {
            if (pr[i] == 1) {
                for (int j = i * i; j <= right; j += i) {
                    pr[j] = 0;
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (pr[i] == 1) list.add(i);
        }

        if (list.size() < 2) return new int[]{-1, -1};

        int[] ans = new int[2];
        int diff = right - left + 1;

        for (int x = 0; x < list.size() - 1; x++) {
            if(list.get(x + 1) - list.get(x) < diff) {
                ans[0] = list.get(x);
                ans[1] = list.get(x + 1);
                diff = list.get(x + 1) - list.get(x);
            }
        }

        return ans;
    }


    public static void main(String[] args) {

    }
}
