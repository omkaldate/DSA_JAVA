package array_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthprimeFactor {
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {

        List<Float> list = new ArrayList<>();
        int a=0, b=0;
        int i=0;
        int j=arr.length;

        while(i<= j){
            j--;
            float num = (float)arr[i]/arr[j];
            list.add(num);

            if(i+1 == j){
                i++;
                j = arr.length;
            }
        }
        Collections.sort(list);
        float ans = list.get(k-1);
        i = 0;
        j = arr.length;

        while(i<=j){
            j--;
            float num = (float)arr[i]/arr[j];
            if(num == ans){
                a = arr[i];
                b = arr[j];
                break;
            }

            if(i+1 == j){
                i++;
                j = arr.length;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args){
        int[]arr = {1,2,3,5};
        int k=3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr , k)));
    }
}
