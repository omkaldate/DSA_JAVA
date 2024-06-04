package string;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int n = s.length();
        int ans = 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (char c : s.toCharArray()) {
            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
        }

        boolean isOdd = false;
        for (Map.Entry<Character, Integer> entry : mpp.entrySet()) {
            int fr = entry.getValue();
            if (fr % 2 == 0) {
                ans += fr;
            }
            else {
                ans += fr - 1;
                isOdd = true;
            }
        }
        return isOdd ? ans + 1 : ans;
    }


    public static void main(String[] args){
        String s = "abssbbnk";
        System.out.println(longestPalindrome(s));
    }
}
