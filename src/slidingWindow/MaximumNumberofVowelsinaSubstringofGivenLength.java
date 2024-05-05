package slidingWindow;

public class MaximumNumberofVowelsinaSubstringofGivenLength {
    public static boolean isVowel(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            return true;
        return false;
    }

    public static int maxVowels(String s, int k) {
        int i = 0;
        int j = 0;
        int cnt = 0;
        int ans = 0;

        while (j < s.length()) {
            if (isVowel(s.charAt(j))) {
                cnt++;
            }
            if (j - i + 1 == k) {
                ans = Math.max(cnt, ans);
                if (isVowel(s.charAt(i)))
                    cnt--;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "isthisiscleartiis";
        System.out.println(maxVowels(s , 4));
    }
}
