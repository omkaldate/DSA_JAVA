package REVISION.Rrcursion;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class LinearSearch {

    public static boolean isPresent(int[]arr,int target,int i){
        if(i == arr.length)return false;

        if(arr[i] == target) return true;
        return isPresent(arr,target,++i);
    }

    public static int isIndex(int[]arr,int target,int i){
        if(i == arr.length)return -1;

        if(arr[i] == target) return i;
        return isIndex(arr,target,++i);
    }

    //making every time new array llist
    public static ArrayList<Integer> funk(int[]arr,int target,int i){
        ArrayList<Integer> st = new ArrayList<>();
        if(i==arr.length)return st;

        if(arr[i] == target)st.add(i);
        st.addAll(funk(arr, target, ++i));
        return st;
    }


    //sending array List by call
    public static void funk(int[]arr,int i,int target,ArrayList<Integer> ls){
        if(i==arr.length)return;

        if(arr[i] == target) ls.add(i);
        funk(arr,++i,target,ls);
    }


    public static void main(String[] args) {
        int[]arr = {1,3,4,5,6,6,8,8,8};
       // System.out.println(isPresent(arr,7,0));
       // System.out.println(isIndex(arr,4,0));
       // System.out.println(funk(arr,6,0));

        ArrayList<Integer>ls = new ArrayList<>();
        funk(arr,0,6,ls);
        System.out.println(ls);
    }
}
