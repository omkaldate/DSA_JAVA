package leetCodeContest.Weekly411;

public class CountSubStringThatSatisfyKConstraint_I {
    public static int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        int start = 0;
        int totalSubstrings = 0;


        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '0'){
                count0++;
            }
            else{
                count1++;
            }


            while (count0 > k && count1 > k) {
                if (s.charAt(start) == '0') {
                    count0--;
                } else {
                    count1--;
                }
                start++;
            }
            totalSubstrings += (i - start + 1);
        }
        return totalSubstrings;
    }

    public static void main(String[] args) {
        String s = "10101";
        System.out.println(countKConstraintSubstrings(s,1));
    }
}
