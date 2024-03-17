package leetcode_Questions;

public class _35_insertposition_bs {

    public static int main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        int target = 5;


        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            }
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return start;
    }
}


