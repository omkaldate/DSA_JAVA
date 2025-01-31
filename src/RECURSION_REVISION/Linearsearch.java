package RECURSION_REVISION;

import org.w3c.dom.ls.LSOutput;

public class Linearsearch {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,6,6,78};
        //System.out.println(fun(arr,5, 0));

        System.out.println(fun1(arr,4,0));
    }

    public static boolean fun(int[]arr , int target, int ind){
        if(ind == arr.length -1){
            if(arr[ind] == target) return true;
            else return false;
        }

        if(arr[ind] == target) return(true);
        else return fun(arr,target,ind+1);
    }

    public static int fun1(int[]arr , int target, int ind){
        if(ind == arr.length-1){
            if(arr[ind] == target) return ind;
            else return -1;
        }

        if(arr[ind] == target) return(ind);
        else return fun1(arr,target,ind+1);
    }




}
