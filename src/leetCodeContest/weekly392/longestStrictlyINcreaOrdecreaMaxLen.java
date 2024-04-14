package leetCodeContest.weekly392;
/*You are given an array of integers nums. Return the length of the longest
subarray of nums which is either strictly increasing or strictly decreasing
.
Example 1:
Input: nums = [1,4,3,3,2]

Output: 2
Explanation:
The strictly increasing subarrays of nums are [1], [2], [3], [3], [4], and [1,4].
The strictly decreasing subarrays of nums are [1], [2], [3], [3], [4], [3,2], and [4,3].
Hence, we return 2.
*/

public class longestStrictlyINcreaOrdecreaMaxLen {
    public static void main(String[] args){
        int arr[] = {4,3,1};
        System.out.println(longestMonotonicSubarray(arr));
    }

    public static int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int num=0,max=0;
        int num1=0 , min=0;

        for(int i =0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
                num++;
                if(num>max) {
                    max = num;
                }
            }
            else{
                num=0;
            }


            if(nums[i]>nums[i+1]) {
                num1++;
                if (num1 > min) {
                    min = num1;
                }
            }
                else{
                    num1=0;
                }
        }
        System.out.println(max+1);
        System.out.println(min+1);
        return Math.max(max+1 , min+1);
    }
}
