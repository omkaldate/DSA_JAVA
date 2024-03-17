package binarySearch_4_hoursProblems;

public class _33_bs_int_rotatedArray {
    public static void main(String[] args) {

        int[] arr = {9, 10, 1,1,1, 2, 3,3, 4, 5};
        System.out.println(start(arr, 5));

    }

    public static int start(int[] arr, int target) {
        int pivot = pivot(arr);
        System.out.println(pivot);
        if (arr[pivot] == target) {
            return pivot;
        }
        if (pivot == -1) {
            return binaryS(arr, target, 0, arr.length - 1);
        }
        if (arr[0] <= target) {
            return binaryS(arr, target, 0, pivot - 1);
        } else {
            return binaryS(arr, target, pivot + 1, arr.length - 1);
        }

    }


   /* public static int pivot (int[]arr){
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

*/

    public static int binaryS(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    // function for the duplicate element array
    public static int pivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < arr.length && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }
            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                if(arr[start] > arr[start+1]){
                    return start;
                }
                start ++;
                if(arr[end] < arr[end-1]){
                    return end-1;
                }
                end--;

            }
            else if(arr[start] < arr[mid] || arr[start] == arr[mid]  &&  arr[mid] > arr[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return -1;
    }
}