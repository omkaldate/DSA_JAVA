
package array;
import java.util.Arrays;
import java.util.HashSet;

public class NumbersOfAverageDistinctAverages {
    public static int distinctAverages(int[] nums) {
        int n = nums.length;

        HashSet<Float> mpp = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0; i<n/2; i++){
            float avg = (float)(nums[i]+nums[n-i-1])/2;
            mpp.add(avg);
        }
        return mpp.size();
    }

    public static void main(String[] args){
        int []arr = {9,5,7,8,7,9,8,2,0,7};
        System.out.println(distinctAverages(arr));

    }
}
