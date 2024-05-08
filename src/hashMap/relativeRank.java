package hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class relativeRank {
    public static String[] findRelativeRanks(int[] score) {
        int n = score.length;

        int[]arr = new int[n];
        for(int x=0; x<n ; x++){
            arr[x] = score[x];
        }

        Arrays.sort(arr);
        HashMap<Integer,Integer>mpp = new HashMap<>();
        for(int i=0; i<n; i++){
            mpp.put(arr[i] , n-i);
        }

        String[]str = new String[n];

        for(int i=0; i<n; i++){
            if(score[i] == arr[n-1]){
                str[i] = "Gold Medal";
            }
            else if(score[i] == arr[n-2]){
                str[i] = "Silver Medal";
            }
            else if(score[i] == arr[n-3]){
                str[i] = "Bronze Medal";
            }
            else{
                str[i] = Integer.toString(mpp.get(score[i]));
            }
        }
        return str;
    }

    public static void main(String[] args){
    int [] arr = {5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(arr)));
    }
}
