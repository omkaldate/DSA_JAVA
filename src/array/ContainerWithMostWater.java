package array;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int n = height.length;
        int i=0;
        int j = n-1;
        int maxArea =0;


        while(i < j){
            int length = Math.min(height[i] , height[j]);
            int breadth = j - i;
            maxArea =  Math.max(length * breadth, maxArea);
            if(height[i] < height[j]) i++;
            else{
                j--;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        int []arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));
    }
}
