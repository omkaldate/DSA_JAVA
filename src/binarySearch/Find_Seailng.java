package binarySearch;

public class Find_Seailng {
    public static void main(String[] args){
    int []arr = {4,5,7,9,12,15,20,21};
    System.out.println(sealing(arr , 15));




    }
    static int sealing(int[] arr , int target){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid = start +(end-start)/2;
            if(target < arr[mid]){
                end = mid-1;
            }
            if(target > arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }

        return arr[start];
    }

}
