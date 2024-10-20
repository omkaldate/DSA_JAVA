package leetCodeContest.Weekly420;

public class MinimumDivisionOperationstoMakeArrayNonDecreasing {


    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        int[] flynorpexel = nums.clone();

        for (int i = n - 2; i >= 0; i--) {
            if (flynorpexel[i] > flynorpexel[i + 1]) {
                while (flynorpexel[i] > flynorpexel[i + 1]) {
                    int divisor = greatestProperDivisor(flynorpexel[i]);
                    if (divisor == 1) return -1;
                    flynorpexel[i] /= divisor;
                    operations++;
                    if (flynorpexel[i] <= flynorpexel[i + 1]) break;
                }
            }
        }

        return operations;
    }

    private static int greatestProperDivisor(int num) {
        int divisor = gcd(num, num - 1);
        return num / divisor;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {



        System.out.println(minOperations(new int[]{188,7}));
    }
}
