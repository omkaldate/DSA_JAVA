package leetcode_Questions;

public class _1283_smallDivisor_givenThreshold {

    public static void main(String[] args){

        int[]nums = { 44,22,33,11,1};
        int threshold = 5;
        System.out.println(smallestDivisor(nums , threshold));

    }
    public static int smallestDivisor(int[] nums, int threshold) {

        if(threshold < nums.length) return -1;
        int start = 1;
        int end = Integer.MIN_VALUE;
        for(int i : nums){
            end = Math.max(end , i);
        }

        while(start <= end ){
            int mid = start +(end-start)/2;
            if(isDivisible(nums , mid , threshold)==0 ){
                end = mid-1;
            }
            else if(isDivisible(nums , mid , threshold)== 1 ) start = mid+1;
            else end = mid-1;
        }
        return start;
    }

    public static int isDivisible(int[]arr , int mid , int threshold){
        int ceiling =0;
        for(int i=0; i< arr.length ; i++){
            ceiling += (double) Math.ceil( (double) arr[i] / mid);
        }
        if(ceiling == threshold) return 0;
        if(ceiling > threshold ) return 1;
        return 2;
    }
}
