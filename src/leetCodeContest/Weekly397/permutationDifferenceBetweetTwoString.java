package leetCodeContest.Weekly397;

import java.util.HashMap;

public class permutationDifferenceBetweetTwoString {
    public static int findPermutationDifference(String s, String t) {
        int cnt =0;

        HashMap<Character,Integer> mpp = new HashMap<>();
        HashMap<Character,Integer>mpp1 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            mpp.put(s.charAt(i) , i);
            mpp1.put(t.charAt(i),i);
        }

        for(int i=0; i<s.length(); i++){
            cnt += Math.abs(mpp.get(s.charAt(i)) - mpp1.get(s.charAt(i)));
        }
        return cnt;
    }

    public static void main(String[] args){
        System.out.println(findPermutationDifference("abc" , "bac"));
    }
}
