package leetCodeContest.Weekly407;

public class VowelsGameinaString {

    public static boolean doesAliceWin(String s) {
        int vowels = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isVowel(ch)) vowels++;
        }

        if(vowels > 0) return true;
        else return false;
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }

    public static void main(String[] args) {
        System.out.println(doesAliceWin("leetcoder"));
    }
}
