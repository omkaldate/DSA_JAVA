package hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class RankTansformOfAnArray {
    public static int[] arrayRankTransform(int[] rank) {
        int[]arr = new int[rank.length];

        for(int i=0; i<arr.length; i++){
            arr[i] = rank[i];
        }

        Arrays.sort(arr);
        HashMap<Integer,Integer> mpp = new HashMap<>();

        int x = Integer.MAX_VALUE;
        int r = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == x) continue;
            mpp.put(arr[i] , r++);
            x = arr[i];
        }

        for(int i=0; i<rank.length; i++){
            rank[i] = mpp.get(rank[i]);
        }

        return rank;
    }

    public static void main(String[] args) {

    }
}
