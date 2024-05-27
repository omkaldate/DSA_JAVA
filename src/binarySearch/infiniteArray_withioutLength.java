package binarySearch;

public class infiniteArray_withioutLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 24, 35, 46, 56, 57, 68, 71, 79, 89};
        System.out.println(index(arr , 10));

    }
    static int index(int[]arr , int target){
       int start =0;
       int end = 1;
       while(target > arr[end]){
           int temp = end+1;
           end=end+(end-start+1)*2;
           start = temp;
       }
      return  find(arr , target , start , end);

    }


    static int find(int[]arr , int target , int start , int end){
        while(start <= end){
            int mid = start+(end-start)/2;
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
        return -1;

    }
}


