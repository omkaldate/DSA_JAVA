package basicPrograms;

public class peak_in_mountain {

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 8,10, 5, 3, 0};
        System.out.println(peakInMountain(arr));

    }

    static int peakInMountain(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
           int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid+1]) {
                start = mid+1;
            }
            else{
                end = mid;
            }

        }
       return start ;

    }
}
