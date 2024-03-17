package leetcode_Questions;

public class _2540_minumunCommonValue {
    public static void main(String[] args){
        int [] arr ={1,5,5,2,7,9,5,3,5,7,8};
        int[]arr2 = {8,6,5,2,3,8,0,6,5,1,3,6,8};
        System.out.println(getCommon(arr , arr2));
    }


    public static int getCommon(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int n1 = nums2.length;

        int i=0 , j =0;
        while(i <n && j <n1){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }
            else if( nums1[i] <= nums2[j]){
                i++;
            }

            else{
                j++;
            }
        }
        return -1;



    }
}

