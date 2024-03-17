package leetcode_Questions;

public class _33_search_rotated_array {

    public static void main(String[] args){

        int[] nums={11,12,13,14,55,56,3,4,5,6,7,8,9};
        int ans = search(nums ,5 );
        System.out.println(" the target presetn at " + ans + " index ");

    }

    static int search(int []arr , int target){
        int peak = findPeak(arr);
        System.out.println( " the peak is " + peak);

        if(peak == -1){
            return binSearch(arr, target , 0 , arr.length-1);
        }
        if(arr[peak] == target){
            return peak;
        }
        if(target >= arr[0]){
            return binSearch(arr , target , 0 , peak-1);
        }
        return binSearch(arr , target , peak+1 , arr.length-1);

    }


    static int binSearch(int[]arr , int target , int start , int end){
     while(start <= end){
         int mid = start+(end-start)/2;

         if(target < arr[mid]){
             end = mid-1;
         }
         else if(target > arr[mid]){
             start = mid+1;
         }
         else {
             return mid;
         }
      }
         return -1;
    }


    static int findPeak(int[]arr){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start +(end-start)/2;

            if( mid < end  &&  arr[mid] > arr[mid+1]){
                return mid;
            }
             if( mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
             if (arr[start] >= arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
