package binarySearch;

public class FindifArrayCanBeSorted {
    public static boolean canSortArray(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = 0; j < n-i-1; j++) {
                if(nums[j] <= nums[j+1]) {
                    continue;
                }
                if(Integer.bitCount(nums[j]) == Integer.bitCount(nums[j+1])) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                } else {
                    return false;
                }
            }
            if(!flag) return true;
        }
        return true;
    }


    public static void main(String[] args) {
        
    }
}
