package hashMap;

public class countElementOfArray {
    public static void main(String[] args){
        int []arr = {1,2,4,5,3,1,1,4,5,2};
        int n = arr.length;

        int[]hash = new int[6];

        for(int i=0; i<n; i++){
            int ind = arr[i];
            hash[ind]++;
        }

        for(int j=0;j<6; j++){
            System.out.println( j + " " + hash[j]);
        }
    }
}
