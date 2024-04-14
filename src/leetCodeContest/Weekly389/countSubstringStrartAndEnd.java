package leetCodeContest.Weekly389;
/*
You are given a string s and a character c. Return the total number of
substrings of s that start and end with c.

Example 1
Input: s = "abada", c = "a"
Output: 6
Explanation: Substrings starting and ending with "a" are: "abada", "abada", "abada", "abada", "abada", "abada".
 */


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
