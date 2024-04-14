package leetCodeContest.Biweekly128;
/*
You are given a string s. The score of a string is defined as the sum of the absolute difference between the
 ASCII values of adjacent characters.Return the score of s.

Example 1:
Input: s = "hello"
Output: 13
Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111.
 So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.
 */
public class scoreofAString {
    public static void main(String[] args){
            String s = "hello";
            scoreOfString(s);
    }

    public static void scoreOfString(String s) {
        int sum =0;
        int i=0;

        while(i+1 < s.length()){
            int subtract =s.charAt(i) - s.charAt(i+1) ;
            sum += Math.abs(subtract);
            i++;
        }
        System.out.println(sum);

    }
}
