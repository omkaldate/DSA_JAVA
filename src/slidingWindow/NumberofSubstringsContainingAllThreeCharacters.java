package slidingWindow;

import java.util.HashMap;

public class NumberofSubstringsContainingAllThreeCharacters {

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        HashMap<Character, Integer> mpp = new HashMap<>();
        int l = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {
            char ch = s.charAt(r);
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

            while (mpp.size() == 3) {
                ans += n - r;

                char chl = s.charAt(l);
                mpp.put(chl, mpp.get(chl) - 1);
                if (mpp.get(s.charAt(l)) == 0) mpp.remove(chl);
                l++;
            }
        }
        return ans;
    }


        public static void main(String[] args) {

    }
}
