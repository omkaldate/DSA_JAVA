package binarySearch;

public class pivot_in_rotaterArray {
    public static void main(String[] args){

    int[] arr= {9,10,1,2,3,4,5};
    System.out.println(pivot(arr));

    }

     public static int pivot (int[]arr){
    int start = 0;
    int end = arr.length-1;

    while(start <= end){
        int mid = start+(end-start)/2;
        if(mid < arr.length  &&  arr[mid] > arr[mid+1]){
            return mid;
        }
        if(mid > 0  &&  arr[mid] < arr[mid-1]){
            return mid-1;
        }
        if(arr[start] > arr[mid]){
            end = mid-1;
        }
        else{
            start = mid+1;
        }
    }
    return -1;
}

}
