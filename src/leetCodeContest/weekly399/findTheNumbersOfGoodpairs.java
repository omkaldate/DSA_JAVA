package leetCodeContest.weekly399;

public class findTheNumbersOfGoodpairs {
    public static int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int  n1 = nums2.length;
        int cnt =0;
        int index =0;

        for(int i=0; i<n1; i++){
            for(int j=0; j<n; j++){
                if(nums1[j] % (nums2[index]*k) == 0 ){
                    cnt++;

                }
            }
            index++;
        }
        return cnt;
    }

    public static void main(String[] args){
        int []nums1 = {1,3,4};
        int []nums2 = {1,3,4};
        int k=1;

        System.out.println(numberOfPairs(nums1 , nums2 , k));
    }
}
