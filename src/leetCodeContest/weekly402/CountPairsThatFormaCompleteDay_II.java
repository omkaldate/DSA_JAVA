package leetCodeContest.weekly402;

import java.util.HashMap;

public class CountPairsThatFormaCompleteDay_II {
    public static long countCompleteDayPairs(int[] hours) {
        int n=hours.length;
        int[] remainder = new int[n];

        for(int i=0; i<n; i++){
            remainder[i] = (hours[i]%24);
        }

        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            mpp.put(remainder[i],mpp.getOrDefault(remainder[i],0)+1);
        }

        long cnt=0;
        cnt+= mpp.getOrDefault(0,0) * (long)(mpp.getOrDefault(0,0)-1)/2;
        cnt+= mpp.getOrDefault(12,0) * (long)(mpp.getOrDefault(12,0)-1)/2;
        for(int i=1; i<12; i++){
            cnt += mpp.getOrDefault(i,0) * (long)mpp.getOrDefault(24-i , 0);
        }
        return cnt;
    }




    public static void main(String[] args) {
        int[] arr = {12, 12, 30, 24, 24};
        System.out.println(countCompleteDayPairs(arr));
    }
}

