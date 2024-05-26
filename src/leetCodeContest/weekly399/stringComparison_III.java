package leetCodeContest.weekly399;

public class stringComparison_III {
    public static String compressedString(String word) {

            int n = word.length();
            StringBuilder st = new StringBuilder();
            char prev = word.charAt(0);
            int cnt = 1;
            int p =0;


            for (int i = 1; i < n; i++) {
                char ch = word.charAt(i);
                if (cnt == 9) {
                    st.append(cnt);
                    st.append(prev);
                    prev = ch;
                    p=i;
                    cnt = 1;
                } else if (prev == ch) {
                    cnt++;
                } else {
                    st.append(cnt);
                    st.append(prev);
                    prev = ch;
                    cnt = 1;
                    p = i;

                }
            }

        cnt =0;
        for( int x = p; x<n; x++){
            cnt++;
            if(cnt==9){
                st.append(cnt);
                st.append(word.charAt(n-1));
                cnt =0;
            }
            if(x == n-1){
                st.append(cnt);
                st.append(word.charAt(n-1));
            }

        }

            return st.toString();
        }


    public static void main(String[] args){
        String s = "aaaaaaaaaay";
        System.out.println(compressedString(s));
    }
}
