package leetCodeContest.Biweekly126;

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
