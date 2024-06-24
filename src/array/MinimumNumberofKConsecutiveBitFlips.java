package array;

public class MinimumNumberofKConsecutiveBitFlips {
    public static int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        int change = 0;
        int n = nums.length;

        int[] limit = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = (nums[i] + change) % 2;

            if (nums[i] == 0) {
                if (i + k - 1 >= nums.length) return -1;
                else {
                    limit[i + k - 1] = 1;
                    change++;
                    flips++;
                }
            }
            change -= limit[i];
        }
        return flips;
    }

    public static void main(String[] args){
        int []arr = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(minKBitFlips(arr , k));
    }
}
