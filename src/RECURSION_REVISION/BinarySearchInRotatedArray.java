package RECURSION_REVISION;

public class BinarySearchInRotatedArray {
    public static void main(String[] args) {
        int[]arr = {6,7,8,1,2,3,4,5};
        System.out.println(fun(arr,0,arr.length-1, 3));
    }

    public static int fun(int[]arr, int s,int e, int target){
        if(s > e) return -1;

        int m= s+(e-s)/2;
        if(arr[m] == target) return m;

        if(arr[s] <= arr[m]){
           if(target >= arr[s] && target <= arr[m]) return fun(arr, s, m - 1, target);
           else return fun(arr, m + 1, e, target);
        }
        else {
            if(target >= arr[m] && target <= arr[e]) return fun(arr, m+1,e,target);
            else return fun(arr,s,m-1,target);
        }
    }
}
