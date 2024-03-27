package recursion;

public class binarySeaRchrotatedArray {
    public static void main(String[] args){
        int []arr = {3,6,7,8,9,1,2,3};
        System.out.println(search(arr , 8,0,arr.length-1));
    }

    static int search(int[]arr ,int target, int s , int e){
        if(s > e){
            return -1;
        }
        int m = s+(e-s)/2;
        if(arr[m] == target){
            return m;
        }

        if(arr[s] <= arr[m]){
            if(target >= arr[s] && target <= m){
                return search(arr,target,0,m-1);
            }
            else{
                return search(arr,target,s+1,m);
            }
        }

        if(target >= arr[m] && target <=arr[e]){
            return search(arr,target,m+1,e);
        }
        return search(arr,target,s,m-1);

    }
}
