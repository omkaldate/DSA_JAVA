package sortingAlgorithms;

import java.util.Arrays;
class cyclicSort_findMissing {

    public static void main(String[] args){

        int[]nums = {5,4,0,6,2,1};
       int result =  missingNumber(nums);
       System.out.println(result);
    }

    static int missingNumber(int[] nums) {
        int i =0;
        while(i < nums.length){
          int  index = nums[i];
            if(nums[i] < nums.length  &&  nums[i] != nums[index]){
                swap(nums , i , nums[i]);
            }
            else{
                i++;
            }
        }
 
         for(int j=0; j< nums.length; j++){
             if(nums[j] != j){
            return j;
            }
         }
         return nums.length;
    }

    static void swap(int[] arr ,int first , int second){
        int temp;
        temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}