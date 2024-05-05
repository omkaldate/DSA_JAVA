package leetCodeContest.weekly396;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class minimumLengthOfAnagramConcatination {
    private static int findGCD(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        if (a == 0) {
            return b;
        }
        return a;
    }


    public static void main(String[] args){
        String s = "abba";
        System.out.println(minAnagramLength(s));
    }

    public static int minAnagramLength(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        int gcd = 0;
        for(int i = 0; i < list.size(); i++) {
            gcd = findGCD(gcd, list.get(i));
        }

        int ans = 0;
        for(int i = 0; i < list.size(); i++) {
            ans += list.get(i) / gcd;
        }
        return ans;
    }
}
