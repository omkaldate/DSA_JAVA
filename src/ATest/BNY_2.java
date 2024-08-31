package ATest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNY_2 {

    public static String palindromeChecker(String s, int[] startIndex, int[] endIndex, int[] subs) {
        StringBuilder result = new StringBuilder();
        int q = startIndex.length;

        for (int i = 0; i < q; i++) {
            int start = startIndex[i];
            int end = endIndex[i];
            int maxSubs = subs[i];

            if (start > end || start < 0 || end >= s.length()) {
                result.append("0");
                continue;
            }

            // Count frequency of characters in the substring
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int j = start; j <= end; j++) {
                char c = s.charAt(j);
                freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            }

            // Count odd frequency characters
            int oddCount = 0;
            for (int count : freqMap.values()) {
                if (count % 2 != 0) {
                    oddCount++;
                }
            }

            // Check if we can convert to palindrome with the given number of substitutions
            if (oddCount <= maxSubs) {
                result.append("1");
            } else {
                result.append("0");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Sample test case
        String s = "cdecd";
        int[] startIndex = {0, 0, 0, 0};
        int[] endIndex = {0, 1, 2, 3};
        int[] subs = {0, 1, 1, 0};

        System.out.println(palindromeChecker(s, startIndex, endIndex, subs));  // Output: "1110"

        // Another test case
        s = "xxdnssuqevu";
        startIndex = new int[]{0};
        endIndex = new int[]{10};
        subs = new int[]{3};

        System.out.println(palindromeChecker(s, startIndex, endIndex, subs));  // Output: "1"
    }
}
