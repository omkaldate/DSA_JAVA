package string;

public class reverseOnlyLetters {
    public static void main(String[] args) {
        String s = "ab-cd";
        char[] arr = s.toCharArray();
        System.out.println(reverseOnlyLetters(arr));

    }

    public static String reverseOnlyLetters(char[] s) {
        int i=0;
        int j = s.length - 1;
        StringBuilder build = new StringBuilder();

        while (i<j) {
            while ((s[i]*1 <65 && s[i]*1 >90) || (s[i]*1 <97 && s[i]*1 >122)) {
                i++;
            }
            while ((s[j]*1 <65 && s[j]*1 >90) || (s[j]*1 <97 && s[j]*1 >122)) {
                j++;
            }
            swap(s,i,j);
        }
        for(char ch : s){
            build.append(ch);
        }
      return build.toString();

    }
    public static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] =temp;
    }
}