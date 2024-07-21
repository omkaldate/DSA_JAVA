package leetCodeContest.Weekly407;

public class NumberofBitChangestoMakeTwoIntegersEqual {
    public static int minChanges(int n, int k) {
        if(n == k) return 0;

        String n1 = Integer.toBinaryString(n);
        String k1 = Integer.toBinaryString(k);

        if(n1.length() > k1.length()) {
            int extra = n1.length() - k1.length();
            String newK1 = "";

            while(extra > 0) {
                newK1 += "0";
                extra--;
            }

            newK1 += k1;
            k1 = newK1;
        }
        else if (n1.length() < k1.length()) {
            int extra = k1.length() - n1.length();
            String newn1 = "";

            while(extra > 0) {
                newn1 += "0";
                extra--;
            }

            newn1 += n1;
            n1 = newn1;
        }

        int ans = 0;
        for(int i = 0; i < n1.length(); i++) {
            char ch1 = n1.charAt(i);
            char ch2 = k1.charAt(i);

            if(ch1 == ch2) {
                continue;
            }
            else if(ch1 == '1' && ch2 == '0') {
                ans += 1;
            }
            else if(ch1 == '0' && ch2 == '1') return -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minChanges(13,4));
    }
}
