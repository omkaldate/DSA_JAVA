package recursion;

import java.util.HashSet;

public class SplitaStringIntotheMaxNumberofUniqueSubstrings {

    private static void solve(String s, int idx, HashSet<String> st, int currCount, int[] maxCount) {
        if(currCount + (s.length() - idx) <= maxCount[0]) {
            return;
        }

        if (idx == s.length()) {
            maxCount[0] = Math.max(maxCount[0], currCount);
            return;
        }

        for (int j = idx; j < s.length(); j++) {
            String sub = s.substring(idx, j + 1);
            if (!st.contains(sub)) {
                st.add(sub);
                solve(s, j + 1, st, currCount+1 , maxCount);
                st.remove(sub);
            }
        }
    }

    public static int maxUniqueSplit(String s) {
        HashSet<String> st = new HashSet<>();
        int[] maxCount = new int[1];
        solve(s, 0, st, 0, maxCount);
        return maxCount[0];
    }


    public static void main(String[] args) {

    }
}
