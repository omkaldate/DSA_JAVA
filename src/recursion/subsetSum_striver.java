package recursion;

import java.util.ArrayList;
import java.util.Collections;

public class subsetSum_striver {
    public static void main(String[] args){
        ArrayList<Integer>arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        int N = arr.size();

        ArrayList<Integer> sumSubset = new ArrayList<>();
        func(0,0,arr,N,sumSubset);
        Collections.sort(sumSubset);
        System.out.println(sumSubset);
    }

   static void func(int ind , int sum , ArrayList<Integer>arr , int N , ArrayList<Integer>sumSubset){
        if(ind == N){
            sumSubset.add(sum);
            return;
        }
        func(ind+1 , sum+arr.get(ind),arr,N,sumSubset);
        func(ind+1,sum,arr,N,sumSubset);
    }
}
