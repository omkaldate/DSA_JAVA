package slidingWindow;

public class _2962_findSubArrMaxelementAppearsAtLeastKTime {
    public static void main(String[] args){
        int[]arr = {1,3,2,3,3};
        System.out.println(countSubarrays(arr,2));
    }

    public static long countSubarrays(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        for(int x=0; x<n; x++){
            if(max < nums[x]){
                max = nums[x];
            }
        }

        int i=0,j=0;
        long result=0;
        int countMax = 0;

        while(j<n){
            if(nums[j] == max){
                countMax++;
            }

            while(countMax >= k){
                result += n-j;
                if(nums[i] == max){
                    countMax--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}

