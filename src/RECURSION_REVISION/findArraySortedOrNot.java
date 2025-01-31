package RECURSION_REVISION;

public class findArraySortedOrNot {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,5};
        System.out.println(fun(arr, 0));
    }

    public static boolean fun(int[]arr, int ind){
        if(ind == arr.length-1){
            return true;
        }

        if(arr[ind] < arr[ind+1]){
            return fun(arr,ind+1);
        }
        return false;
    }
}
