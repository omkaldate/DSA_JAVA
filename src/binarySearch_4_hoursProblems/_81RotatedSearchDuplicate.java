package binarySearch_4_hoursProblems;

public class _81RotatedSearchDuplicate {
    public static void main(String[] args) {
        int[] arr = {29, 29, 30, 41, 42, 50, 11, 18, 24, 25};
        System.out.println(searchInARotatedSortedArrayII(arr, 29));
    }

    public static boolean searchInARotatedSortedArrayII(int []arr, int target) {

        int pivot = pivot(arr);
        // System.out.println(pivot);
        if (arr[pivot] == target) {
            return true;
        }

        if (arr[0] <= target) {
            int b= binaryS(arr, target, 0, pivot - 1);
            if(b < 0){
                return false;
            }
            else{
                return true;
            }
        } else {
            int c= binaryS(arr, target, pivot + 1, arr.length - 1);
            if(c < 0) return false;
            else return true;
        }

        // return false;

    }


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
