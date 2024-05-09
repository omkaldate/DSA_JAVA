package array;

import java.util.Arrays;

public class maximizeHappinessOfSelectedChildrens {
    public static long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        int cnt = 0;
        long sum = 0;

        Arrays.sort(happiness);

        for (int i = 0; i < k; i++) {
            if (happiness[n - i - 1] >= cnt) {
                sum +=(long) happiness[n - i - 1] - cnt;
                cnt++;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int[] happiness = {1,2,3};
        int k=2;
        System.out.println(maximumHappinessSum(happiness , k));
    }
}
