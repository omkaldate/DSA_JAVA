package basicPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class addingarrInr2dArr {
    public static void main(String[] args){
    int[][]intervals = {{1,3},{6,9}};
    int[]newInterval = {2,5};

    int[][]ans= insert(intervals , newInterval);

    for(int i=0; i<ans.length; i++){
        for(int j=0;j<ans[i].length; j++){
            System.out.println(ans[i][j]);
        }
        System.out.println();
    }


    }


    public static  int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] arr = new int[intervals.length + 1][2];

        for(int i = 0; i < intervals.length; i++) {
            for(int j = 0; j < intervals[i].length; j++) {
                arr[i][j] = intervals[i][j];
            }
        }

        arr[arr.length - 1][0] = newInterval[0];
        arr[arr.length - 1][1] = newInterval[1];

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> lst = new ArrayList<>();

        int start = arr[0][0];
        int end = arr[0][1];

        for(int[] a : arr) {
            if(a[0] <= end) {
                end = Math.max(end, a[1]);
            }
            else {
                lst.add(new int[]{start, end});
                start = a[0];
                end = a[1];
            }
        }

        lst.add(new int[] {start, end});

        int[][] ans = lst.toArray(new int[0][]);

        return ans;
    }
}
