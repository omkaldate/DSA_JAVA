package basicPrograms;

public class forEachLoop {
    public static void main(String[] args){
        int [][]arr = {
                {11,22,33,44,55},
                {66,77,88,99,10}

        };

        for(int[]i : arr){
            for(int j : i){
                System.out.println(j);
            }
        }
    }
}
