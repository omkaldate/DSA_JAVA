package binarySearch_4_hoursProblems;
import java.util.Arrays;

public class findOccurance_intFirst_andLast {
    public static void main(String[] args){

        int []arr = {1,2,3,4,5,5,5,6,7,90,100,456,735};
        findOccurance_intFirst_andLast obj = new findOccurance_intFirst_andLast();
       int[]ans = obj.find(arr , 5);
       System.out.println(Arrays.toString(ans));
    }

    public int[] find(int[]arr ,int target){
        int[]ans = {-1 , -1};
        ans[0] = search(arr , target , true);
        if(ans[0] != -1) {
            ans[1] = search(arr, target, false);
        }
        return ans;
    }


       public int search(int[]arr , int target , boolean findStart){
        int ans = -1;
        int start=0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                ans = mid;
                if(findStart ){
                    end=mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
     return ans;
    }
}
