package array;

public class RemovingMinimumandMaximumFromArray {

    public static int minimumDeletions(int[] nums) {
        if(nums.length == 1) return 1;

        int miniInd = 0;
        int maxiInd = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < nums[miniInd]) {
                miniInd = i;
            }

            if(nums[i] > nums[maxiInd]) {
                maxiInd = i;
            }
        }

        int front = 0;
        boolean maxBack = false;

        if(miniInd > maxiInd) {
            front = miniInd + 1;
        }
        else {
            front = maxiInd + 1;
        }

        int back = 0;
        if(miniInd < maxiInd) {
            back = nums.length - miniInd;
        }
        else {
            back = nums.length - maxiInd;
            maxBack = true;
        }

        int sum = 0;

        if(maxBack) {
            sum += maxiInd + 1;
            sum += nums.length - miniInd;
        }
        else {
            sum += miniInd + 1;
            sum += nums.length - maxiInd;
        }
        return Math.min(back, Math.min(sum , front));
    }

    public static void main(String[] args) {
        int[]arr = {2,10,7,5,4,1,8,6};
        System.out.println(minimumDeletions(arr));
    }
}


