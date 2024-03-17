package leetcode_Questions;

import java.sql.SQLOutput;

public class _152_optimal_MaximumProductSubarray {

    public static void main(String[] args){
    int []arr = {4,5,6,-8,0,-7,-7,6,7,8,3,0,-1,0,0,7,4};
        System.out.println(product(arr));
    }

  public static int product(int[]nums){
      int n= nums.length;
      int pre =1;
      int suf=1;
      int maxi = Integer.MIN_VALUE;

      for(int i=0; i<n; i++){
          if(pre ==0) pre=1;
          if(suf ==0) suf =1;

          pre *= nums[i];
          suf *= nums[n-i-1];
          maxi = Math.max(maxi , Math.max(pre , suf));
      }
      return maxi;
  }

}

