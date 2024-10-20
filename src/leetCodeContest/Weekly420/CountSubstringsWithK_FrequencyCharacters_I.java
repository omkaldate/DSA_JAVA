package leetCodeContest.Weekly420;

public class CountSubstringsWithK_FrequencyCharacters_I {

    public static int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int[] arr = new int[26];
        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            arr[ch - 'a']++;

            while (arr[ch - 'a'] >= k) {
                ans += n - right;
                arr[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
