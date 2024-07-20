package leetCodeContest.Biweekly135;

import java.util.HashMap;
import java.util.Map;

public class MinimumLengthofStringAfterOperations {

    public static int minimumLength(String s) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> second = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(!first.containsKey(ch)) {
                first.put(ch, i);
            }
            else if(!second.containsKey(ch)) {
                second.put(ch, i);
            }
            else {
                first.remove(ch);
                int value = second.remove(ch);
                first.put(ch, value);
            }
        }
        return first.size() + second.size();
    }

    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
    }

}
