package REVISION.Rrcursion;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumber {
     private static void dfs(int current, int n, List<Integer> result) {
         if (current > n) {
             return;
         }
         result.add(current);
         for (int i = 0; i <= 9; i++) {
             int next = current * 10 + i;
             if (next > n) {
                 break;
             }
             dfs(next, n, result);
         }
     }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();

        int n = 10;
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        System.out.println(result);
    }
}
