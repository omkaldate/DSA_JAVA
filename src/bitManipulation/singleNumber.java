package bitManipulation;

public class singleNumber {
    public static void main(String[] args){
    int[]nums = {2,2,1};
        System.out.println(singlenum(nums));
    }

    public static int singlenum(int[]nums){
    int n = nums.length;
    int xorr =0;
      for(int i=0; i<n ; i++){
        xorr = xorr ^ nums[i];
    }

      return xorr;

    }
}
