package leetCodeContest.weekly404;

public class MaximumHeightofaTriangle {
    public static int maxHeightOfTriangle(int red, int blue) {
        int r=red;
        int b=blue;

        int cnt=0;
        int cnt2=0;

        int i=1;
        boolean x =true;

        while(blue>=0 && red>=0 ){

            if(x==true){
                if(blue-i <0)break;
                blue = blue-i;
                x=false;
            }
            else if(x==false){
                if(red-i <0)break;
                red = red-i;
                x=true;
            }
            cnt++;
            i++;
        }

        i=1;
        x =false;

        while(b>=0 && r>=0 ){

            if(x==true){
                if(b-i <0)break;
                b = b-i;
                x=false;
            }
            else if(x==false){
                if(r-i <0) break;
                r = r-i;
                x=true;
            }
            cnt2++;
            i++;
        }


        return Math.max(cnt,cnt2);

    }

    public static void main(String[] args) {
        System.out.println(maxHeightOfTriangle(2,4));
    }
}
