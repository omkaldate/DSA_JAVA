package array;

import java.util.Arrays;

public class HeightChecker {
    public static int heightChecker(int[] heights) {
        int n = heights.length;
        int cnt =0;
        int[]arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = heights[i];
        }
        Arrays.sort(arr);

        for(int i=0; i<n; i++){
            if(heights[i] != arr[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args){
        int[]heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}
