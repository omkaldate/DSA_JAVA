package sortingAlgorithms;

import java.util.Arrays;

public class BS_int_2D_arr_symmitric {
    public static void main(String[] args) {

        int[][]arr ={
                {10,20,30,40,50},
                {11,21,31,41,51},
                {15,25,35,45,55},
                {17,27,39,46,60}
        };

        System.out.println(Arrays.toString(search(arr ,45)));

    }

    static int []search(int[][]arr ,int target ){
        int r=0;
        int c=arr.length;
        System.out.println(c);

        while(r <= arr.length && c >= 0){
            if(arr[r][c] == target){
                return new int[]{r , c};
            }
            if(arr[r][c] < target){
                r++;
            }
            else{
                c--;
            }
        }
        return new int[]{-1 , -1};

    }

}