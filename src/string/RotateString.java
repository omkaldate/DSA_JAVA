package string;

public class RotateString {
    public static void LPS(String s, int[] arr) {
        int pre = 0;
        int suf = 1;

        while (suf < arr.length) {
            if (s.charAt(pre) == s.charAt(suf)) {
                arr[suf] = pre + 1;
                pre++;
                suf++;

            } else {
                if (pre == 0) suf++;
                else pre = arr[pre - 1];
            }
        }
    }

    public static boolean rotateString(String s, String goal) {

        if(s.length() != goal.length()) return false;
        String str = s + s;

        int[] arr = new int[goal.length()];
        LPS(goal, arr);

        int fir = 0;
        int sec = 0;
        while (fir < str.length() && sec < goal.length()) {
            if (str.charAt(fir) == goal.charAt(sec)) {
                fir++;
                sec++;
            } else {
                if (sec == 0) fir++;
                else sec = arr[sec - 1];
            }
        }

        if(sec == goal.length()) return true;
        return false;
    }


    public static void main(String[] args) {
        System.out.println(rotateString("abcde","cdeab"));
    }
}
