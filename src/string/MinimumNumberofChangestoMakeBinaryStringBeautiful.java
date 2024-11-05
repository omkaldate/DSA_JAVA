package string;

public class MinimumNumberofChangestoMakeBinaryStringBeautiful {
    public static int minChanges(String s) {
        int i=0, c=0;
        while(i<s.length()-1) {
            if(s.charAt(i) != s.charAt(i+1)) c++;
            i+=2;
        }
        return c;
    }


    public static void main(String[] args) {

    }
}
