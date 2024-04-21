package leetCodeContest.WeeklyContest394;

import java.util.HashSet;
import java.util.Set;

public class CounttheNumberofSpecialCharacters_I {
    public static void main(String[] args){
        String word = "aaAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }

    public static int numberOfSpecialChars(String word) {
        Set<Character> set = new HashSet<>();

        // store the lower character
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                set.add(ch);
            }
        }

        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                char lowerCase = Character.toLowerCase(ch);
                if (set.contains(lowerCase)) {
                    ans++;
                    set.remove(lowerCase);
                }
            }
        }
        return ans;
    }
}
