package string;

import java.util.HashMap;

public class _205_isomorphicString {
    public static void main(String[] args){
       String s = "egg";
       String t = "odd";
        System.out.println(isIsomorphic(s,t));
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp1 = new HashMap<>();
        HashMap<Character, Character> mp2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);

            if (!mp1.containsKey(ch1)) {
                mp1.put(ch1, ch2);
            }
            if (!mp2.containsKey(ch2)) {
                mp2.put(ch2, ch1);
            }

            if (mp1.get(ch1) != ch2 || mp2.get(ch2) != ch1) {
                return false;
            }
        }

        return true;

    }
}
