package leetCodeContest.Weeklycontest393;

public class latestTimeAfterReplacingCharacter {
    public static void main(String [] args){
        String str="?0:?3";

        char[] s = str.toCharArray();
        if (s[0] == '?') {
            s[0] = (s[1] == '?' || s[1] < '2') ? '1' : '0';
        }
        if (s[1] == '?') {
            s[1] = (s[0] == '1') ? '1' : '9';
        }
        if (s[3] == '?') {
            s[3] = '5';
        }
        if (s[4] == '?') {
            s[4] = '9';
        }
        String ans = new String(s);
        System.out.println(ans);
    }
}
