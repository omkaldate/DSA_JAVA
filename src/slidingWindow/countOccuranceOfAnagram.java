package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class countOccuranceOfAnagram {
    public static void main(String[] args){
        String s = "aabaabaa";
        String pat = "aaba";
        int n= s.length();
        int n2 = pat.length();

        int i=0,j=0;
        int cnt = 0;
        HashMap<Character , Integer> mpp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (char ch : pat.toCharArray()) {
            mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);
        }
         cnt = mpp.size();

        while(j < n){
            if (mpp.containsKey(s.charAt(j))) {
                mpp.put(s.charAt(j), mpp.get(s.charAt(j)) - 1);

                if (mpp.get(s.charAt(j)) == 0) {
                    cnt--;
                }
            }
            if ((j - i + 1) < n2) {
                j++;
            }
            else if ((j - i + 1) == n2) {
                if (cnt == 0) {
                    ans.add(i);
                }

                if (mpp.containsKey(s.charAt(i))) {
                    mpp.put(s.charAt(i), mpp.get(s.charAt(i)) + 1);

                    if (mpp.get(s.charAt(i)) == 1) {
                        cnt++;
                    }
                }

                i++;
                j++;
            }
        }

        System.out.println(ans);

    }
}
