package stack;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {

        public static int maximumGain(String s, int x, int y) {
            return (x > y) ? helper(s, x, y, 'a', 'b') : helper(s, y, x, 'b', 'a');
        }

        private static int helper(String s, int x, int y, char c1, char c2){
            Stack<Character> st = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int score = 0;
            for (char ch : s.toCharArray()) {
                if (!st.isEmpty() && st.peek() == c1 && ch == c2){
                    st.pop();
                    score += x;
                }
                else {
                    st.push(ch);
                }
            }
            while (!st.isEmpty()) {
                sb.append(st.pop());
            }
            sb.reverse();
            for (char ch : sb.toString().toCharArray()){
                if (!st.isEmpty() && st.peek() == c2 && ch == c1){
                    st.pop();
                    score += y;
                }
                else {
                    st.push(ch);
                }
            }
            return score;
        }


    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab",4,5));
    }
}
