package TwoPointers;

public class ShortestSubarraytobeRemovedtoMakeArraySorted {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int ans = 0;

        while (right > 0 && arr[right - 1] <= arr[right]) {
            right --;
        }

        if (right == 0) return 0;

        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left ++;
        }

        ans = Math.min(n - left - 1, right);;

        int i = 0;
        while (i <= left && right < n) {
            if (arr[i] <= arr[right]) {
                ans = Math.min (ans, right - i - 1);
                i ++;
            } else {
                right ++;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        findLengthOfShortestSubarray(arr);
    }
}
