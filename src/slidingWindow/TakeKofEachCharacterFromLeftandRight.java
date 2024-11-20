package slidingWindow;

public class TakeKofEachCharacterFromLeftandRight {
    public static int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int x : count) {
            if (x < k) {
                return -1;
            }
        }
        int maxLength = 0, j = 0;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            count[c]--;
            while (count[c] < k) {
                count[s.charAt(j++) - 'a']++;
            }
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return n - maxLength;
    }
}
