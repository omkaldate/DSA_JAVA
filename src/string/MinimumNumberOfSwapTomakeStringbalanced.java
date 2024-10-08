package string;

public class MinimumNumberOfSwapTomakeStringbalanced {
    public static int minSwaps(String s) {
        int size = 0;
        for(char ch:s.toCharArray()){
            if (ch=='[') size++;
            else{
                if (size>0) size--;
            }
        }

        return (size+1)/2;
    }

    public static void main(String[] args) {

    }
}
