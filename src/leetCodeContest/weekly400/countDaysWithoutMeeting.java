package leetCodeContest.weekly400;

import java.util.Arrays;

public class countDaysWithoutMeeting {
    public static int countDays(int days, int[][] meetings) {
        int row = meetings.length;
        int col = meetings[0].length;

        Arrays.sort(meetings, (a, b) -> a[0]-b[0]);
        int cnt =0;
        int big = meetings[0][col-1];

        if(meetings[0][0] >1) cnt+= meetings[0][0]-1;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if((i+1 < row) && meetings[i][col-1] < meetings[i+1][0] && meetings[i][col-1]>=big ){
                    cnt += meetings[i+1][0]-meetings[i][col-1]-1;
                }
                big = Math.max(big , meetings[i][col-1]);

                break;
            }
        }
        int x = Math.max(big , meetings[row-1][col-1]);
        if(x < days) {
            cnt += days - x;
        }
        return cnt;
    }


    public static void main(String[] args){
        int [][]arr = {
                {5,7},
                {1,3},
                {9,10}
        };
        System.out.println(countDays(10,arr));
    }
}
