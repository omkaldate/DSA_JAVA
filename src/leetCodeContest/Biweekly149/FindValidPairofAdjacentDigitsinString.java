package leetCodeContest.Biweekly149;

import java.util.HashMap;

public class FindValidPairofAdjacentDigitsinString {
    public static void main(String[] args) {

    }


    public static String findValidPair(String s) {
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            int val = s.charAt(i)-'0';
            mpp.put(val, mpp.getOrDefault(val,0)+1);
        }

        String ans ="";

        for(int i=0; i<s.length()-1; i++){
            int first = mpp.get(s.charAt(i)-'0');
            int second =  mpp.get(s.charAt(i+1)-'0');

            if(first == s.charAt(i)-'0' && second == s.charAt(i+1)-'0'){
                if(first != second){
                    ans += Integer.toString(first);
                    ans += Integer.toString(second);
                    return ans;
                }
            }

        }
        return "";

    }
}
