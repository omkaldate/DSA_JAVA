package array;

import java.util.ArrayList;
import java.util.Arrays;

public class klargestelements {

    public static ArrayList<Integer> kLargest(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);

        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=n-1; i>n-k-1; i--) ans.add(arr[i]);

        return ans;
    }

    public static void main(String[] args) {

    }
}
