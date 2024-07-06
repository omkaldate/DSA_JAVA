package leetCodeContest.Biweekly134;

public class AlternatingGroups {
    public static int numberOfAlternatingGroups(int[] colors) {
        int n = colors.length;
        int cntZero =0;
        int cntOne =0;

        if(n>2){
            if(colors[0] == 0){
                if(colors[1] == 1 && colors[n-1]==1)cntZero++;
            }
            else{
                if(colors[1] == 0 && colors[n-1]==0)cntOne++;
            }
            if(colors[n-1]==0){
                if(colors[n-2]==1 && colors[0]==1)cntZero++;
            }
            else{
                if(colors[n-2]==0 && colors[0]==0)cntOne++;
            }
        }

        for(int i=1; i<=n-2; i++){
            if(colors[i] == 0){
                if(colors[i-1] == 1 && colors[i+1] == 1) cntZero++;
            }
            else{
                if(colors[i-1] == 0 && colors[i+1] == 0) cntOne++;
            }
        }
        return cntZero+cntOne;
    }

    public static void main(String[] args) {
        int arr[] = {0,1,0,0,1};
        System.out.println(numberOfAlternatingGroups(arr));
    }
}
