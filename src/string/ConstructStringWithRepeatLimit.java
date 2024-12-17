package string;

public class ConstructStringWithRepeatLimit {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; // Frequency array to store character counts

        // Count the frequency of each character
        for (char ch : s.toCharArray()) { // T.C: O(n)
            count[ch - 'a']++;
        }

        StringBuilder result = new StringBuilder();
        int i = 25; // Start from the largest character (z)

        while (i >= 0) { // T.C: O(26)
            if (count[i] == 0) {
                i--;
                continue;
            }

            char ch = (char) ('a' + i); // Convert index to character
            int freq = Math.min(count[i], repeatLimit); // Append up to 'repeatLimit' times

            for (int k = 0; k < freq; k++) {
                result.append(ch);
            }
            count[i] -= freq;

            if (count[i] > 0) {
                // Find the next largest character
                int j = i - 1;
                while (j >= 0 && count[j] == 0) { // O(26)
                    j--;
                }

                if (j < 0) {
                    break; // No more characters left to append
                }

                result.append((char) ('a' + j)); // Append the next largest character once
                count[j]--;
            }
        }

        return result.toString();
    }


    public static void main(String[] args) {
        
    }
}
