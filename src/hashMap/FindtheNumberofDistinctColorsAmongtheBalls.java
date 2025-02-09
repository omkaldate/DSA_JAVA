package hashMap;

import java.util.HashMap;

public class FindtheNumberofDistinctColorsAmongtheBalls {
    public static void main(String[] args) {

    }

    public static int[] queryResults(int limit, int[][] queries) {
        int[]ans = new int[queries.length];
        HashMap<Integer,Integer> mppTrack = new HashMap<>();
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=0; i<queries.length; i++){
            int node = queries[i][0];
            int color = queries[i][1];

            if(mppTrack.containsKey(node)){
                int prevCol = mppTrack.get(node);
                mppTrack.put(node,color);

                mpp.put(prevCol, mpp.get(prevCol)-1);
                if(mpp.get(prevCol) == 0) mpp.remove(prevCol);

                mpp.put(color,mpp.getOrDefault(color,0)+1);
                ans[i] = mpp.size();
            }

            else{
                mppTrack.put(node,color);
                mpp.put(color,mpp.getOrDefault(color,0)+1);
                ans[i] = mpp.size();
            }
        }
        return ans;
    }
}
