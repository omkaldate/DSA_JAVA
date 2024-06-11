package hashMap;

import java.util.*;

public class RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int[]arr = new int[n1];
        HashMap<Integer,Integer> mpp = new HashMap<>();

        for(int i=0; i<n1; i++){
            mpp.put(arr1[i] , mpp.getOrDefault(arr1[i] , 0)+1);
        }

        int x=0;
        for(int i=0; i<n2; i++){
            int cnt = mpp.get(arr2[i]);
            for(int j=0; j<cnt; j++){
                arr[x++] = arr2[i];
            }
            mpp.put(arr2[i],0);
        }

        ArrayList<Integer> ls = new ArrayList<>();
        for(Map.Entry<Integer,Integer> val : mpp.entrySet()){
            if(val.getValue() != 0){
                int occur = val.getValue();
                for(int i=0; i<occur; i++){
                    ls.add(val.getKey());
                }
            }
        }
        Collections.sort(ls);
        for(int j=0; j<ls.size(); j++){
            arr[x++] = ls.get(j);
        }

        return arr;
    }

    public static void main(String[] srgs){
        int[]arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[]arr2 = {2,1,4,3,9,6};
        System.out.println(Arrays.toString(relativeSortArray(arr1,arr2)));
    }
}
