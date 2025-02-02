package leetCodeContest.Biweekly149;

import java.util.ArrayList;

public class RescheduleMeetingsforMaximumFreeTimeI {
    public static void main(String[] args) {
            
    }

    public static int maxFreeTime(int eventTime, int k, int[] sTime, int[] eTime) {
        ArrayList<Integer> list =new ArrayList<>();

        list.add(sTime[0]-0);
        for(int i=1; i<sTime.length; i++) list.add(sTime[i] - eTime[i-1]);
        list.add(eventTime - eTime[eTime.length-1]);
        System.out.println(list);


        int ans = 0;
        int i=0;
        int j= 0;
        int sum =0;

        while(j < list.size()){
            sum += list.get(j);
            if (j - i + 1 < k + 1) j++;
            else if (j - i + 1 == k + 1) {
                ans = Math.max(ans, sum);
                sum -= list.get(i);
                i++;
                j++;
            }
        }
        return ans;
    }
}
