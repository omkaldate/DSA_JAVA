package leetCodeContest.Weekly389;
/*
Given a string s, find any
substring of length 2 which is also present in the reverse of s.Return true if such a substring exists, and false otherwise.

Example 1:
Input: s = "leetcode"
Output: true
Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".
 */
public class ExistenceOfSubstringAndItsReverse {
    public static void main(String[] args) {
     String str ="abab";
        System.out.println(isSubstringPresent(str));

    }

    public static boolean isSubstringPresent(String s) {
        int n=s.length();
        String rev ="";
        char c;
        for(int i=0; i<n; i++){
            c = s.charAt(i);
            rev = c+rev;
        }

        for(int j=0; j<n-1; j++){
            String sub = rev.substring(j,j+2);
            if(s.contains(sub)) return true;
        }

        return false;
    }
}
