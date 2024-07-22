package hashMap;

import java.util.Arrays;
import java.util.HashMap;

public class SortThepeople {
        public static String[] sortPeople(String[] names, int[] heights) {
            HashMap<Integer, String> mpp = new HashMap<>();

            for (int i = 0; i < heights.length; i++) {
                mpp.put(heights[i], names[i]);
            }

            Arrays.sort(heights);
            for (int i = 0; i < heights.length / 2; i++) {
                int x = heights[i];
                heights[i] = heights[heights.length - i - 1];
                heights[heights.length - i - 1] = x;
            }

            for (int i = 0; i < heights.length; i++) {
                names[i] = mpp.get(heights[i]);
            }
            return names;
        }

    public static void main(String[] args) {
        String[] names = {"Mary","John","Emma"};
        int[] heights = {180,165,170};
        System.out.println(Arrays.toString(sortPeople(names,heights)));

    }
}
