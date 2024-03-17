package recursion_practice;

import java.util.Arrays;
public class recursion_selectionSort {
    public static void main(String[] args){
    int[] arr = {9,8,7,6,5,4,3,2,1};
    selection(arr , arr.length ,0 , 0);
    System.out.println(Arrays.toString(arr));

  }
  static void selection(int[]arr , int index , int c , int max){
        if(index==0){
            return;
        }

        if(c<index){
            if(arr[c] > arr[max]){
                selection(arr , index ,c+1 , c);
            }
            else{
                selection(arr , index , c+1 , max);
            }
        }
        else{
            int temp = arr[max];
            arr[max] = arr[index-1];
            arr[index-1] = temp;
            selection(arr , index-1 , 0 , 0);
        }
  }

}
