package recursion_practice;

import java.util.Arrays;
public class recursion_bubbleSort {
    public static void main(String[] args){
        int[]arr = {9,8,7,6,5,4,3,2,1};
        bubble(arr , 8,0);
        System.out.println(Arrays.toString(arr));

    }
    static void bubble(int[]arr , int e , int j){
        if(e==0){
            return;
        }
        if(j < e){
            if(arr[j] > arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            bubble(arr , e , j+1);
        }
        else{
            bubble(arr , e-1 , 0);
        }
    }
}
