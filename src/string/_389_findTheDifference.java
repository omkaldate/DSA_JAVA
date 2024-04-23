package string;

public class _389_findTheDifference {
    public static void main(String[] args){
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }

    public static char findTheDifference(String s, String t) {
        int n = Math.min(s.length() , t.length());
        int sum =0;

        for(int i=0; i<n; i++){
            sum ^= s.charAt(i);
            sum ^= t.charAt(i);
        }
        sum ^= t.charAt(n);
        return (char)sum;
    }
}
