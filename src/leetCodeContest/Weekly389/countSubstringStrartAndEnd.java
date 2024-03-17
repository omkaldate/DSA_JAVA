package leetCodeContest.Weekly389;

import java.util.HashMap;

public class countSubstringStrartAndEnd {
    public static void main(String[] args){
        String str = "abada";
        System.out.println(countSubstrings(str , 'a'));
    }

    public static long countSubstrings(String s, char c) {
        int n=s.length();
        long cnt=0;
        HashMap<Character,Integer> mpp = new HashMap<>();
        mpp.put(c,0);

        for(int i=0 ; i<n; i++){
            if(s.charAt(i) == c){
                cnt++;
            }
            if(mpp.containsKey(s.charAt(i))){
                cnt+= mpp.get(s.charAt(i));
                mpp.put(s.charAt(i) , mpp.get(s.charAt(i))+1);
            }

        }

        return cnt;
    }
}
