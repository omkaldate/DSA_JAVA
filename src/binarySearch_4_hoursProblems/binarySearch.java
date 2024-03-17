package binarySearch_4_hoursProblems;

public class binarySearch {
    public static void main(String[] args){

        int []arr = {1,2,3,4,5,6,7,90,100,456,735};

    System.out.println(search(arr , 456));
    }

    static int search(int[]arr ,int target){
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
                return mid;
            }
        }
        return -1;
    }
}


