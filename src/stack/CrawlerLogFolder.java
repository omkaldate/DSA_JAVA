package stack;

import java.util.Stack;

public class CrawlerLogFolder {
    public static int minOperations(String[] logs) {
        int cnt=0;
        for(String i : logs){
            if(i!="./"  &&  i!="../"){
                cnt++;
            }
            else{
                if(cnt>0  &&  i== "../") cnt--;
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        String[]str = {"d1/","d2/","./","d3/","../","d31/"};
        System.out.println(minOperations(str));
    }
}
