package string;

public class ShortestPalindrome {
    public static void computeLps(String str, int[] lps) {
        int pre = 0;
        int suf = 1;

        while (suf < str.length()) {
            if (str.charAt(pre) == str.charAt(suf)) {
                lps[suf] = pre + 1;
                pre++;
                suf++;
            } else {
                if (pre == 0) {
                    lps[suf] = 0;
                    suf++;
                } else {
                    pre = lps[pre - 1];
                }
            }
        }

    }

    public static String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String temp = s + "-" + rev;

        int[] lps = new int[temp.length()];
        computeLps(temp, lps);

        int longestLpsLength = lps[temp.length() - 1];

        String culprit = rev.substring(0, s.length() - longestLpsLength);

        return culprit + s;
    }

    public static void main(String[] args) {

    }
}
