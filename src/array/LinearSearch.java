package array;

public class LinearSearch {

    public static int isPresent(int[]arr , int target){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target) return i;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[]arr = {1,2,3,4,6,90,100};
        System.out.println(isPresent(arr,90));
    }
}
