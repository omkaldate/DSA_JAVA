package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class maximusDistanceInArrays {
    public static int maxDistance(List<List<Integer>> arrays) {
        int minVal = arrays.get(0).get(0);
        int maxVal = arrays.get(0).get(arrays.get(0).size() - 1);
        int ans = 0;


        for (int i = 1; i < arrays.size(); i++) {
            int cMin = arrays.get(i).get(0);
            int cMax = arrays.get(i).get(arrays.get(i).size() - 1);

            ans = Math.max(ans, Math.abs(cMax - minVal));
            ans = Math.max(ans, Math.abs(maxVal - cMin));


            minVal = Math.min(minVal, cMin);
            maxVal = Math.max(maxVal, cMax);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3));

        System.out.println(maxDistance(arrays));


    }
}
