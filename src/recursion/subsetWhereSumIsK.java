package recursion;


import java.util.ArrayList;
import java.util.Arrays;

public class subsetWhereSumIsK {
    public static void main(String[] args){
    int[]arr = {1,2,1};
    int k = 2;
    ArrayList<Integer> list = new ArrayList<>();
    funk(0,list,0,k,arr);
    }

    static void funk(int i,ArrayList<Integer> list,int sum,int k,int[]arr){
        if(i==arr.length){
            if(k == sum){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[i]);
        sum+= arr[i];
        funk(i+1,list,sum,k,arr);

        list.remove(list.size()-1);
        sum-= arr[i];
        funk(i+1,list,sum,k,arr);
    }

}
