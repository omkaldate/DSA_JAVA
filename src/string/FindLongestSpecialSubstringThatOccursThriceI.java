package string;

import java.util.HashMap;
import java.util.Map;

public class FindLongestSpecialSubstringThatOccursThriceI {
    public static int maximumLength(String s) {
        Map<Pair<Character, Integer>, Integer> count = new HashMap<>();
        int substringLength = 0;

        for (int start = 0; start < s.length(); start++) {
            char character = s.charAt(start);
            substringLength = 0;

            for (int end = start; end < s.length(); end++) {
                if (character == s.charAt(end)) {
                    substringLength++;
                    Pair<Character, Integer> key = new Pair<>(character, substringLength);
                    count.put(key, count.getOrDefault(key, 0) + 1);
                } else {
                    break;
                }
            }
        }

        int ans = 0;
        for (Map.Entry<Pair<Character, Integer>, Integer> entry : count.entrySet()) {
            int length = entry.getKey().getValue();
            if (entry.getValue() >= 3 && length > ans) {
                ans = length;
            }
        }

        return ans == 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(maximumLength("aaabaaaab")); // Example test
    }
}
