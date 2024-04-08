package array;

import java.util.Arrays;

public class removeElement {
    public static void main(String[] args){
        int[]arr = {1,2,3,4,3,4,3,1};
        System.out.println(removeElement(arr , 3));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == val) {
                nums[i] = -1;
                cnt++;
            }
        }
        int e = nums.length - 1;

        while (e >= 0 && nums[e] == -1) {
            e--;
        }
        int s = 0;

        while (s < e) {
            if (nums[s] == -1) {
                swap(nums, s, e);

                while (e >= 0 && nums[e] == -1) {
                    e--;
                }
            }

            s++;
        }

        return n - cnt;
    }

    static void swap(int[]arr,int i,int e){
        int temp =arr[i];
        arr[i] = arr[e];
        arr[e] = temp;
    }
}
