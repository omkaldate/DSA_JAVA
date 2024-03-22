package slidingWindow;

import java.util.HashSet;

public class _3_longestSebstringWithoutRepeatingChar {
    public static void main(String[] args){
        String s ="abcdabcdabb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int i=0 , j=0 ,maxLength=0;

        while(j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength,  j-i+ 1);
                j++;
            }
            else{
                set.remove(s.charAt(i));
                i++;
            }

        }
        return maxLength;

    }
}
