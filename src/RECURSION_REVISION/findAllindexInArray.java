package RECURSION_REVISION;

import java.util.ArrayList;

public class findAllindexInArray {
    public static void main(String[] args) {
        int[]arr = {1,2,3,4,4,4,5,6};
        ArrayList<Integer> list = new ArrayList<>();

        //fun(list, arr, 0, 4);
        //System.out.println(list);

        System.out.println(fun(arr,0,4));
    }



//    public static void fun(ArrayList<Integer> list, int[]arr, int ind, int target){
//        if(ind == arr.length){
//            return;
//        }
//
//        if(arr[ind] == target){
//            list.add(ind);
//            fun(list,arr,ind+1,target);
//        }
//        else fun(list,arr,ind+1,target);
//    }


    public static ArrayList<Integer> fun(int[]arr, int ind, int target){
      ArrayList<Integer> list = new ArrayList<>();
      if(ind == arr.length) return list;

      if(arr[ind] == target) list.add(ind);

       list.addAll(fun(arr,ind+1, target));
       return list;
    }


}
