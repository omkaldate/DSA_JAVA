package binarySearch;

public class find_sealingIn_charArray {
    public static void main(String[] args){
        char[]arr ={'a' , 'f' , 'j' , 'x'};
        System.out.println(charSealing(arr , 'h'));
    }

    static int charSealing(char[]arr , char target){
        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid=start +(end-start)/2;
            if(target < arr[mid]){
                end=mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                return mid+1;
            }
        }
        return start;
    }
}
