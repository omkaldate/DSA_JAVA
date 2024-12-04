package string;

public class MakeStringaSubsequenceUsingCyclicIncrements {

    public static boolean canMakeSubsequence(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int i = 0, j = 0;

        while (i < len1 && j < len2) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch1 == ch2 || (ch1 - 'a' + 1) % 26 == (ch2 - 'a')) {
                j++;
            }
            i++;
        }
        return j == len2;
    }


    public static void main(String[] args) {

    }
}
