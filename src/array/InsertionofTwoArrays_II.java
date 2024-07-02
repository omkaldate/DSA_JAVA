package array;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionofTwoArrays_II {

    public static int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n2 = nums2.length;
        ArrayList<Integer> lst = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;

        while(i<n && j<n2){
            if(nums1[i] == nums2[j]){
                lst.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j])i++;
            else{
                j++;
            }
        }
        int []arr = new int[lst.size()];
        for(int x=0; x<lst.size(); x++){
            arr[x] = lst.get(x);
        }
        return arr;
    }


    public static void main(String[] args) {
        int[]arr= {7,1,45,56,45,34,34,34,1,2,4,4,};
        int[]arr2 = {34,34,0,5,7,2,5,6,0};
        System.out.println(Arrays.toString(intersect(arr,arr2)));
    }
}
