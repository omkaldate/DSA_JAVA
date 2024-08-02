package slidingWindow;

public class MinimunSwapToGroupAll1sTogather {
    public static int minSwaps(int[] nums) {

        int n = nums.length;
        int ones = 0;

        for(int i=0 ; i<n ; i++){
            if(nums[i] == 1) ones++;
        }
        if(ones == 0) return 0;

        int i=0,j=0;
        int zeros =0;
        int ans = n;

        while(i<n){
            if(nums[j%n] == 0) zeros++;
            if(Math.abs(j-i)+1 == ones){
                ans = Math.min(ans , zeros);
                //System.out.println(i + " " + j + " " + zeros);
                zeros += (nums[i] == 0) ? -1 : 0;
                i++;
            }

            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[]arr = {1,0,1,1,1,0,0};
        System.out.println(minSwaps(arr));
    }
}
