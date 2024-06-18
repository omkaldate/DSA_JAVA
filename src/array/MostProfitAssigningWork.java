package array;

import java.util.Arrays;

public class MostProfitAssigningWork {
    public static  int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

        int n = profit.length;
        int[][] job = new int[n][2];

        for (int i = 0; i < n; i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }

        Arrays.sort(job,(a, b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(worker);

        int j = 0, res = 0, best = 0;
        for (int i = 0; i < worker.length; i++) {
            while (j < n && worker[i] >= job[j][0]) {
                best = Math.max(best, job[j][1]);
                j++;
            }
            res += best;
        }

        return res;
    }


    public static void main(String[] args){
        int[]difficult = {2,4,6,8,10};
        int[]profit = {10,20,30,40,50};
        int[]worker = {4,5,6,7};

        System.out.println(maxProfitAssignment(difficult,profit,worker));

    }
}
