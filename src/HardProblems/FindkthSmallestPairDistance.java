package HardProblems;

import java.util.Arrays;

public class FindkthSmallestPairDistance {
    public static int countPairs(int[] nums, int diff){
        int left = 0;
        int right = 1;
        int n = nums.length;
        int count = 0;
        while(right < n){
            while(nums[right] - nums[left] > diff){
                left++;
            }
            count += (right - left);
            right++;
        }
        return count;
    }

    public static int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = nums[n-1];
        while(left < right){
            int mid = (left + right)/2;
            if(countPairs(nums,mid) >= k){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        int[]arr = {1,3,1};
        int k = 1;
        System.out.println(smallestDistancePair(arr,k));
    }
}
