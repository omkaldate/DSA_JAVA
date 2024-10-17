package string;

public class MaximumSwap {

    public static int maximumSwap(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        int[] res = new int[2];
        int n = digits.length - 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] > digits[n]) {
                n = i;
            }
            if (digits[i] < digits[n]) {
                res = new int[] { i, n };
            }
        }
        if (res[0] != res[1]) {
            char temp = digits[res[1]];
            digits[res[1]] = digits[res[0]];
            digits[res[0]] = temp;
            int number = Integer.parseInt(new String(digits));
            return number;
        }
        return num;
    }


    public static void main(String[] args) {

    }
}
