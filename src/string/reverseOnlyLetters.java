package string;

public class reverseOnlyLetters {
    public static void main(String[] args) {
        String s = "7-89]";
        char[] arr = s.toCharArray();
        System.out.println(reverseOnlyLetters(arr));

    }

    public static String reverseOnlyLetters(char[] s) {
        int i=0;
        int j = s.length - 1;
        StringBuilder build = new StringBuilder();

        while (i < j) {
            while ((i < j) && (s[i]*1 < 65 || s[i]*1 > 90) && (s[i]*1 <97)) {
                i++;
            }
            while((j > i) && (s[j]*1 < 65 || s[j]*1 > 90) && (s[j]*1 <97)){
                j--;
            }

            if(i < s.length && j >= 0) {
                swap(s,i,j);
                i++;
                j--;
            }
            else {
                break;
            }
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