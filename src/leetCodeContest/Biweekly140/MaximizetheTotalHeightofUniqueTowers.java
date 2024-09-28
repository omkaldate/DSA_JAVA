package leetCodeContest.Biweekly140;

import java.util.Arrays;

public class MaximizetheTotalHeightofUniqueTowers {

    public long maximumTotalSum(int[] maximumHeight) {
         Arrays.sort(maximumHeight);

         int n = maximumHeight.length;
         long totalSum = 0;
         int prevHeight = Integer.MAX_VALUE;

         for (int i = n - 1; i >= 0; i--) {
             int assignedHeight = Math.min(maximumHeight[i], prevHeight - 1);

             if (assignedHeight <= 0) return -1;

             totalSum += assignedHeight;
             prevHeight = assignedHeight;
         }
         return totalSum;
     }

    public static void main(String[] args) {

    }
}
