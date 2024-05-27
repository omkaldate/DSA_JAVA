package binarySearch;

public class hard_1095findinBiotonicArray {
    public static void main(String[] args) {

        int[] mountainArr = {1,2,3,4,5,3,1};
        int target = 3;
        hard_1095findinBiotonicArray obj = new hard_1095findinBiotonicArray();
        int val = obj.search(mountainArr , target);
        System.out.println(val);

    }

        public int search(int[] mountainArr , int target){
        int peak =peakInMountain(mountainArr);
        int firstTry =binarySearch(mountainArr, target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return binarySearch(mountainArr, target, peak+1, mountainArr.length - 1);

    }

    public  int peakInMountain(int[] arr) {
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

    public  int binarySearch(int[]arr , int target , int start , int end){
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
