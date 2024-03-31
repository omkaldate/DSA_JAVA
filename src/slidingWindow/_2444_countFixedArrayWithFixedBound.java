package slidingWindow;

public class _2444_countFixedArrayWithFixedBound {
    public static void main(String[] args){
        int[]arr = {1,3,5,2,7,5};
        System.out.println(countSubarrays(arr , 1 , 5));
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int minKPosition =-1;
        int maxKPosition = -1;
        int culprIDX =-1;

        for(int i=0; i<nums.length; i++){
            if(nums[i] < minK || nums[i] > maxK){
                culprIDX = i;
            }
            if(nums[i] == minK){
                minKPosition = i;
            }
            if(nums[i] == maxK){
                maxKPosition = i;
            }
            long smaller = Math.min(minKPosition , maxKPosition);
            long temp = smaller - culprIDX;
            ans += (temp <= 0)? 0 : temp;
        }
        return ans;
    }
}
