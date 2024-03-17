package leetcode_Questions;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class _1207_uniqueNumber_leetCode {
    public static void main(String[] args){
        int[] arr = {1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));

    }
    static boolean uniqueOccurrences(int[] arr) {
        if(arr.length==1){
            return true;
        }

        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        int count=0;
        int index=0;
        while(index < arr.length) {
            while (index + 1 < arr.length && arr[index] == arr[index + 1]) {
               count++;
               index++;
            }

            list.add(count + 1);
            count=0;
            index++;
        }

        System.out.println(list);
        Collections.sort(list);

        for(int j=0; j<list.size(); j++){
            if(j + 1 < list.size() && list.get(j) == list.get(j+1)){
                return false;
            }
        }

        return true;
    }


}
