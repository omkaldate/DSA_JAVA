package HashSet;

import java.util.HashSet;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public static void main(String[] args){
        int[] arr = {-1,2,-3,3};
        System.out.println(findMaxK(arr));
    }

    public static  int findMaxK(int[] nums) {
        HashSet<Integer> st= new HashSet<>();
        int maxi = -1;

        for(int i=0; i<nums.length; i++){
            if(!st.isEmpty()){
                if(nums[i] < 0 && st.contains(Math.abs(nums[i]))){
                    maxi = Math.max(maxi , Math.abs(nums[i]));
                }
                if(nums[i] >0 && st.contains(-1*nums[i])){
                    maxi = Math.max(maxi , Math.abs(nums[i]));
                }
                else{
                    st.add(nums[i]);
                }
            }
            else{
                st.add(nums[i]);
            }
        }
        return maxi;
    }
}
