package binarySearch_4_hoursProblems;

public class mountain_findPeak {
    public static void main(String[] args){
        int[]arr = {4,5,6,7,9,8,7,6,3};

    }
    static int peak(int[]arr){
        int start = 0;
        int end= arr.length-1;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(arr[mid] > arr[mid+1]){
                end=mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
}
