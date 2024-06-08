package leetCodeContest.Biweekly132;

import java.util.ArrayList;

public class cleardigits {
    public static String clearDigits(String s) {
        int n = s.length();
        String ans ="";
        ArrayList<Character> al = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(s.charAt(i) <=122 && s.charAt(i) >=97 ){
                ans += s.charAt(i);
            }
            else{
                ans = ans.substring(0,ans.length()-1);
            }
        }
        return ans;
    }


    public static void main(String[] ags){
        String s = "cbd34";
        System.out.println(clearDigits(s));
    }
}
