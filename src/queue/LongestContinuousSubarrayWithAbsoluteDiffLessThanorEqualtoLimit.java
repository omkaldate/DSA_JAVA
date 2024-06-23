package queue;
import java.util.PriorityQueue;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int i=0,j=0;
        int res = 0;
        while(j<nums.length){
            min.add(nums[j]);
            max.add(nums[j]);
            while(Math.abs(max.peek()-min.peek()) >limit){
                min.remove(nums[i]);
                max.remove(nums[i]);
                i++;
            }
            res = Math.max(j-i+1,res);
            j++;
        }
        return res;
    }



    public static void main(String[] args){
        int []arr = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(arr,limit));

    }
}
