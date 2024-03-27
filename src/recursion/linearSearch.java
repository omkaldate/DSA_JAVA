package recursion;

import java.util.ArrayList;

public class linearSearch {
    public static void main(String[] args){
    int[]arr = {3,18,1,18,9};
   // System.out.println(search(arr ,12, 0));
   // System.out.println(indexFind(arr ,18, 0));

        //   indexFind(arr , 18,0);
        //     System.out.println(list);

      //  ArrayList<Integer> ans = seconindexFind(arr,18,0,new ArrayList<>());
      //  System.out.println(ans);

        System.out.println(thirdindexFind(arr , 18 , 0 ));
    }

  /*  static boolean search(int[]arr ,int target, int index) {
        if (index == arr.length - 1) {
            return false;
        }
        return arr[index] == target || search(arr, target, index + 1);
    }


    static int indexFind(int[]arr , int target , int index){
        if(arr[index] == target){
            return index;
        }

        if(index == arr.length-1){
            return -1;
        }
        return indexFind(arr,target,index+1);
    }



    static ArrayList<Integer> list = new ArrayList<>();
    static int indexFind(int[]arr , int target , int index){
        if(arr[index] == target){
            list.add(index);
        }

        if(index == arr.length-1){
            return -1;
        }
        return indexFind(arr,target,index+1);
    }



    static ArrayList<Integer> seconindexFind(int[]arr , int target , int index,ArrayList<Integer>list){
        if(arr[index] == target){
            list.add(index);
        }

        if(index == arr.length-1){
            return list;
        }
        return seconindexFind(arr,target,index+1 , list);
    }

   */


    static ArrayList<Integer> thirdindexFind(int[]arr , int target ,int index){
        ArrayList<Integer>list = new ArrayList<>();
        if(arr[index] == target){
            list.add(index);
        }

        if(index == arr.length-1){
            return list;
        }
        ArrayList<Integer> ans = thirdindexFind(arr , target , index+1);
        list.addAll(ans);
        return list;
    }

}
