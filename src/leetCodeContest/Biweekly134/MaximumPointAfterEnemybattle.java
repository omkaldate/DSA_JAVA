package leetCodeContest.Biweekly134;

import java.util.Arrays;

public class MaximumPointAfterEnemybattle {
    public static long maximumPoints(int[] enemy, int cur) {
        int n = enemy.length;
        long pnt = 0;
        int  i = 0;
        int j = n-1;
        Arrays.sort(enemy);

        if(cur == 0 || enemy[0] > cur) return 0;
        while(j>=0){
            if(enemy[i] != -1){
                if(enemy[i]<= cur){
                    pnt += cur / enemy[i];
                    cur = cur % enemy[i];
                }
            }
            cur += enemy[j];
            enemy[j] = -1;
            j--;
        }
        return pnt;
    }

    public static void main(String[] args) {
        int[]arr = {3,2,2};
        System.out.println(maximumPoints(arr,2));
    }

}
