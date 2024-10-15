package TwoPointers;

public class SeparateBlackAndWhiteBalls {

    public static long minimumSteps(String s) {
        int l = 0;
        int r = s.length()-1;

        long ans =0;

        while(l < r){

            while(l<=s.length()-1 && s.charAt(l) == '0') l++;
            while(r>=0 && s.charAt(r) == '1') r--;

            if(l < r){
                ans+= r-l;
                l++;
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
