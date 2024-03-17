package leetcode_Questions;

public class _152_brute_MaximumProductSubarray {

public static void main(String[] args){

    int [] arr = {5,4,0,-1,5,-4};
    System.out.println(subarrayWithMaxProduct(arr));

}

    public static int subarrayWithMaxProduct(int []nums){

        int n=nums.length;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n; i++){
            int product =1;
            for(int j=i;j<n; j++){
                product *= nums[j];
                if(product > ans){
                    ans = product;
                }
            }
        }
        return ans;
    }
}
