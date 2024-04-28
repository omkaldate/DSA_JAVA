package leetCodeContest.weeklyContest395;

public class findTheIntegerAddedToArray_I {
    public static void main(String[] args) {
        int[] nums1 = {2, 6, 4};
        int[] nums2 = {9, 7, 5};
        System.out.println(addedInteger(nums1 , nums2));
    }

    public static int addedInteger(int[] nums1, int[] nums2) {

        int sum1 =0;
        int sum2 =0;

        for(int i=0; i<nums2.length; i++){
            sum1 += nums1[i];
            sum2 += nums2[i];
        }

        int diff = sum2-sum1;
        return diff/nums1.length;
    }
}
