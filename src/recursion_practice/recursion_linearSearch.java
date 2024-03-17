package recursion_practice;

import java.util.ArrayList;
public class recursion_linearSearch {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 95, 4, 95, 6, 7, 8};
        //System.out.println(sorted(arr, 0));
        // System.out.println(findIndex(arr , 95 , 0));
        // System.out.println(findLastIndex(arr , 95, arr.length-1));

        // findAllIndex(arr , 95 , 0);
        // System.out.println(list);

        //System.out.println (findAllIndex2(arr , 95 , 0 ,new ArrayList<>() ));
        System.out.println (findAllIndex3(arr , 95 , 0));


    }

    static boolean sorted(int[] arr, int index) {
        if (index == arr.length - 1) {
            return true;
        }
        return arr[index] < arr[index + 1] && sorted(arr, index + 1);
    }


    static int findIndex(int[] arr, int target, int index) {
        if (index >= arr.length - 1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return findIndex(arr, target, index + 1);
        }
    }

    static int findLastIndex(int[] arr, int target, int index) {
        if (index < 0) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return findLastIndex(arr, target, index - 1);
        }
    }


    static ArrayList<Integer> list = new ArrayList<>();

    static void findAllIndex(int[] arr, int target, int index) {
        if (index >= arr.length - 1) {
            return;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        findAllIndex(arr, target, index + 1);

    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list) {
        if (index >= arr.length - 1) {
            return list;
        }
        if (arr[index] == target) {
            list.add(index);
        }
        return findAllIndex2(arr, target, index + 1, list);
    }

    static ArrayList<Integer> findAllIndex3(int[]arr , int target , int index){
        ArrayList<Integer> list = new ArrayList<>();
        if(index >= arr.length){
            return list;
        }
        if(arr[index] == target){
            list.add(index);
        }

        ArrayList<Integer> allAns = findAllIndex3(arr , target , index+1);
        list.addAll(allAns);
        return list;
    }
}
