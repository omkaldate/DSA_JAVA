package string;

public class MinimumDeletionToMakeStringBalanced {
    public static int minimumDeletions(String s) {

        int cntA =0;
        boolean first = true;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(first && ch == 'b'){
                first = false;
            }
            if(ch == 'a') cntA++;
        }


        int cntB =0;
        int  isB =0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == 'b') isB++;

            if(ch == 'a' && isB > 0){
                isB--;
                cntB++;
            }
        }
        return Math.min(cntA , cntB);
    }

    public static void main(String[] args) {
        String s = "aababbab";
        System.out.println(minimumDeletions(s));
    }
}
