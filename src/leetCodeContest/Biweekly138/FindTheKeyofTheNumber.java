package leetCodeContest.Biweekly138;

public class FindTheKeyofTheNumber {
    public static int generateKey(int num1, int num2, int num3) {
        if(num1 ==0 || num2 ==0  || num3 == 0) return 0;

        int ans =0;
        int cnt =1;

        while(num1 != 0 && num2 !=0 && num3 != 0){
            int n1 = num1%10;
            num1 /= 10;
            int n2 = num2%10;
            num2 /=10;
            int n3 = num3%10;
            num3 /=10;


            int val =Integer.MAX_VALUE;
            val =  Math.min(Math.min(Math.min(val,n1),n2),n3);

            System.out.println(val);

            ans = (cnt*val) + ans;
            cnt *=10;

        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(generateKey(282,718,1024));
    }
}
