package leetCodeContest.Weekly420;

public class MinimumDivisionOperationstoMakeArrayNonDecreasing {


    public static int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        int[] arr = nums.clone();

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                int divisor = fun(arr[i]);
                if (divisor == 1) return -1;
                arr[i] /= divisor;
                operations++;
                if (arr[i] > arr[i + 1]) return -1;
            }
        }
        System.out.println((int) 10.246950766);
        return operations;
    }

    private static int fun(int num) {
        for (int i =2; i <= num/2; i++) {
            if (num % (num/i) == 0) return num/i;
        }
        return 1;
    }



    public static void main(String[] args) {

        System.out.println(minOperations(new int[]{188,7}));
    }
}
