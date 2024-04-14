package leetCodeContest.Biweekly126;
/*
You are given an integer array nums containing positive integers. We define a function encrypt such that encrypt(x) replaces every digit in x with the largest digit in x.
 For example, encrypt(523) = 555 and encrypt(213) = 333.Return the sum of encrypted elements.

Example 1:
Input: nums = [1,2,3]
Output: 6
Explanation: The encrypted elements are [1,2,3]. The sum of encrypted elements is 1 + 2 + 3 == 6.
 */
public class FindSumOfEncryption {
    public static void main(String[] args){
        int[]arr = {123,423,12,12,0};
       System.out.println(sumOfEncryptedInt(arr));
    }

    public static  int sumOfEncryptedInt(int[] nums) {
        int sum =0;
        for(int i=0; i<nums.length; i++){
            sum += digits(nums[i]);
        }
        return sum;
    }

    public static int digits(int num){
        int d=0;
        int max=0;
        int sum=0;
        while(num != 0){
            int n = num%10;
            max = Math.max(max , n);
            num = num/10;
            d++;
        }
        while(d != 0){
            sum = (sum*10) +max;
            d--;
        }
        return sum;
    }
}
