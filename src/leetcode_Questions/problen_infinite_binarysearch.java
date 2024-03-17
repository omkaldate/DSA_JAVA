package leetcode_Questions;

public class problen_infinite_binarysearch {

    public static void main(String [] args){

       int[]arr = { 1,2,3,4,6,8,9,10,10,11,24,54,67,876};
       int target = 54;
       System.out.println( ans(arr , target));
    }

    static int ans(int[]arr , int target){
      int start =0;
      int end =1;

      while(target >arr[end]){
          int temp = end+1;
          end = end+(end-start)*2;
          start = temp;
      }
      return binarySearch(arr ,target  , start , end);

    }

    static int binarySearch (int[]arr , int target  , int start , int end){
    while(start <= end){
        int mid = (start+end)/2;

        if(target < arr[mid]){
            end = mid-1;
        }
        else if(target > arr[mid]){
            start = mid+1;
        }
        else{
            return mid;
        }
    }
    return start;
    }

}
