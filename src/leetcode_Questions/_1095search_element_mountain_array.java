package leetcode_Questions;

public class _1095search_element_mountain_array {

    public static void main(String[] args){

        int[]arr={1,2,3,5,6,7,8,90,100,9,7,6,5,3,2,1};
        int val = search(arr ,90 );
        System.out.println(val);


    }
    static int search(int[] arr, int target) {
        int peak = peakInMountain(arr);
        System.out.println("printing the peak" + peak);
        int firstTry = binarySearch(arr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return binarySearch(arr, target, peak, arr.length - 1);

    }

    static int peakInMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid +1;
            } else {
                end = mid;
            }

        }
        return start;
    }

    static int binarySearch(int[]arr , int target , int start , int end){
        while(start < end){
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



