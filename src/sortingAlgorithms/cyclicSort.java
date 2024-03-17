package sortingAlgorithms;

import java.util.Arrays;
public class cyclicSort {

        public static void main(String[] args){

        int[] arr = {4,5,6,3,2,1};
        search(arr);
        System.out.println( Arrays.toString(arr));

    }

    static void search(int[] arr){
            int i =0;
        while (i < arr.length){
            int correct = arr[i]-1;
            if(arr[i] == arr[correct]){
                i++;
            }
            else{
                swap(arr , i , arr[i]-1);
            }
        }
    }

    static void swap(int[] arr , int first , int second){
            int temp;
            temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;
    }
}
